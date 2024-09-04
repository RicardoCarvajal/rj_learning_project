from repository.quotation.quotation_repository_django import QueryObjectQuotationDjango
from repository.quotation_det.quotation_det_repository_django import (
    QueryObjectQuotationDetDjango,
)
from use_case.qutation_get_use_case import QuotationGetUseCase


# Contenedor de dependencias
class Container:
    def __init__(self):
        self._query_object_quotation = None
        self._query_object_quotation_det = None

    # Repositorios
    @property
    def query_object_quotation(self):
        if self._query_object_quotation is None:
            self._query_object_quotation = QueryObjectQuotationDjango()
        return self._query_object_quotation

    @property
    def query_object_quotation_det(self):
        if self._query_object_quotation_det is None:
            self._query_object_quotation_det = QueryObjectQuotationDetDjango()
        return self._query_object_quotation_det

    # Casos de uso
    @property
    def get_quotation_use_case(self):
        return QuotationGetUseCase(
            queryobject=self.query_object_quotation,
            queryobjectdet=self.query_object_quotation_det,
        )
