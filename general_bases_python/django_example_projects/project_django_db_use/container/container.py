from dependency_injector import containers, providers
from repository.quotation.quotation_repository_django import QueryObjectQuotationDjango
from repository.quotation_det.quotation_det_repository_django import QueryObjectQuotationDetDjango
from use_case.qutation_get_use_case import QuotationGetUseCase

# Contenedor de dependencias
class Container(containers.DeclarativeContainer):
    #Repositorios
    query_objecto_quotation = providers.Singleton(QueryObjectQuotationDjango)
    query_objecto_quotation_det = providers.Singleton(QueryObjectQuotationDetDjango)

    #Casos de uso
    get_quotation_use_case = providers.Factory(QuotationGetUseCase,
        queryobject=query_objecto_quotation,
        queryobjectdet=query_objecto_quotation_det
    )