import json
import boto3
import pandas as pd
import io

def lambda_handler(event, context):
    """
    Función Lambda de AWS que procesa eventos de S3 para archivos CSV.
    Extrae 'product_code' de los registros donde 'Op' es 'I'.
    """
    print(event)
    
    s3_client = boto3.client('s3')

    try:
        # 1. Recuperar el key del object y el nombre del bucket
        record = event['Records'][0]
        bucket_name = record['s3']['bucket']['name']
        object_key = record['s3']['object']['key']

        print(f"Bucket: {bucket_name}")
        print(f"Key: {object_key}")

        # 2. Buscar el archivo CSV con la librería de boto3
        response = s3_client.get_object(Bucket=bucket_name, Key=object_key)
        csv_content = response['Body'].read().decode('utf-8')

        # 3. Revisar el archivo CSV con la librería pandas
        # Usamos io.StringIO para leer el contenido como si fuera un archivo
        df = pd.read_csv(io.StringIO(csv_content))

        # 4. Obtener un array que contenga solo el valor de la columna "product_code",
        # solo de los registros en donde la columna "Op" sea igual a "I"
        filtered_products = df[(df['Op'] == 'I') | (df['Op'] == 'U')]['StellarDocID'].tolist()

        print(f"Product codes: {filtered_products}")

        return {
            'statusCode': 200,
            'body': json.dumps({
                'message': 'Proceso completado exitosamente',
                'extracted_product_codes': filtered_products
            })
        }

    except KeyError as e:
        print(f"Error: No se encontró la clave esperada en el evento: {e}")
        return {
            'statusCode': 400,
            'body': json.dumps({'error': f"Formato de evento incorrecto: {e}"})
        }
    except s3_client.exceptions.NoSuchKey:
        print(f"Error: El objeto '{object_key}' no se encontró en el bucket '{bucket_name}'.")
        return {
            'statusCode': 404,
            'body': json.dumps({'error': f"Objeto S3 no encontrado: {object_key}"})
        }
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")
        return {
            'statusCode': 500,
            'body': json.dumps({'error': f"Error interno del servidor: {e}"})
        }