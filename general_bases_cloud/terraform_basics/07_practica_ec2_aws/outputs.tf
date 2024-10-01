output "ec2_public_ip" {
    value = aws_instance.rjcarvajal-oregon-tf-test-ec2.public_ip
    description = "IP publica de la instancia ec2"
}

output "parameter" {
    value = data.aws_ssm_parameter.dbdbcredential.value
    description = "Parametro que contienen la ARN del secret de la bd"
}