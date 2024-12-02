from pandas import read_csv, DataFrame
from multiprocessing import cpu_count
import rx
from rx import operators as ops
from rx.scheduler import ThreadPoolScheduler
from log import Logger


class ProcessFile():

    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(ProcessFile,cls).__new__(cls)
        return cls._instance

    def __init__(self):
        if not hasattr(self,'init'):
            self.init = True
            self.log = Logger(__class__.__name__)

    def apply_normal(self,path_file):
        self.log.info(f"Se cargo el archivo {path_file}")
        file_data_dictionary = read_csv(path_file)
        df = DataFrame(file_data_dictionary)
        list(map(lambda row:self.save_one_to_one(row[0]), df.iterrows()))

    def apply_reactive(self,path_file):
        cpus = cpu_count()
        self.log.info(f"cpus {cpus}")
        pool = ThreadPoolScheduler(cpus)

        self.log.info(f"Se cargo el archivo {path_file}")
        file_data_dictionary = read_csv(path_file)
        df = DataFrame(file_data_dictionary)

        rx.from_iterable(df.iterrows()).pipe(
            ops.flat_map(lambda row: rx.just(row[0]).pipe(
                ops.subscribe_on(pool),
                ops.map(self.save_one_to_one)
            ))
        ).subscribe(
            on_next=lambda i: self.log.info(f"on_next: {i}"),
            on_error=lambda e: self.log.error(f"on_error: {e}"),
            on_completed=lambda: self.log.info("on_completed")
        )

    def save_one_to_one(self,row):
        return f'Insert {row}'

    


