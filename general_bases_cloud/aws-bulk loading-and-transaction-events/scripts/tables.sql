CREATE DATABASE stellar; 

USE stellar;

EXEC msdb.dbo.rds_cdc_enable_db 'stellar';

CREATE TABLE dbo.current_promo_price (
    branch_office NVARCHAR(255),
    store NVARCHAR(255),
    discountable CHAR(1),
    regular_price DECIMAL(18, 4),
    opportunity_price DECIMAL(18, 4),
    regular_price_with_tax DECIMAL(18, 4),
    opportunity_price_with_tax DECIMAL(18, 4),
    liquidation_opportunity_letter NVARCHAR(MAX),
    promotion_start_date DATE,
    promotion_end_date DATE,
    client_group NVARCHAR(255),
    distribution_channel NVARCHAR(255),
    branch_office_id INT,
    product_code NVARCHAR(255),
    createdat DATETIME,
    tax_indicator DECIMAL(18, 4),
    epa_code NVARCHAR(255),
    short_description NVARCHAR(255),
    long_description NVARCHAR(MAX),
    category_name NVARCHAR(255),
    category_code NVARCHAR(255),
    line_name NVARCHAR(255),
    external_code NVARCHAR(MAX),
    previous_code NVARCHAR(255),
    commodity_code NVARCHAR(255),
    category_type NVARCHAR(255),
    line_code NVARCHAR(255),
    tributary_code NVARCHAR(255),
    sales_unit NVARCHAR(255),
    sales_unit_id INT,
    unit_price NVARCHAR(255),
    employee_discount CHAR(1),
    unit_conversion_factor DECIMAL(18, 4),
    unit_conversion NVARCHAR(255),
    CONSTRAINT PK_current_promo_price_new_pk PRIMARY KEY (store, product_code)
);

CREATE TABLE dbo.TICKET (
	STORE nvarchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	POS nvarchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	SLSEQ numeric(18,0) NOT NULL,
	TICKET numeric(20,0) NOT NULL,
	DDATE datetime NOT NULL,
	TTIME char(8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CASHIER nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	ITEMQTY int NOT NULL,
	TICKETAMOUNT money NULL,
	SERIALFISCAL nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	FISCALTICKETNUMBER int NULL,
	FIRSTFISCALTICKETNUMBER int NULL,
	ZREPORTNUMBER int NULL,
	CUSTOMERID char(15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CUSTOMERPHONE char(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CUSTOMERZONE char(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CUSTOMERNAME char(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CUSTOMER_S char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	REGTYPE char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	TOTALPRICETOT money NULL,
	TOTALDISCOUNTTOT money NULL,
	TOTBAS1 money NULL,
	TOTBAS2 money NULL,
	TOTBAS3 money NULL,
	TOTALTAXTOT money NULL,
	TAX_1_AMT money NULL,
	TAX_2_AMT money NULL,
	TAX_3_AMT money NULL,
	TAX_1_RATE int NULL,
	TAX_2_RATE int NULL,
	TAX_3_RATE int NULL,
	NO_TAX_AMT money NULL,
	RATE_DISCOUNT int NULL,
	StellarDocID nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL PRIMARY KEY,
	Documento_Relacion nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Status numeric(18,0) NOT NULL,
	STATUS_SYNC bit NOT NULL,
	TipoNotaCredito int NOT NULL,
	CustomerTrxPhone nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CustomerTrxEmail nvarchar(150) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Turno int NOT NULL,
	BasIGTF money NULL,
	TotIGTF money NULL,
	IGTF_1_Rate money NULL,
	CodMonedaOrigen nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CodMonedaDestino nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	TasaConversion float NULL,
	n_Imp_IGTF money NULL,
	n_Base_IGTF money NULL,
	n_Porc_IGTF money NULL,
	OdooID int NOT NULL,
	Transaccion_Motivo nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DocumentUID nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	TipoOrigenDoc int NOT NULL,
	TipoOrigenDocAfec int NOT NULL
);


EXEC sys.sp_cdc_enable_table
    @source_schema = N'dbo', 
    @source_name = N'TICKET',
    @role_name = NULL,
    @supports_net_changes = 1;

EXEC sys.sp_cdc_enable_table
    @source_schema = N'dbo', 
    @source_name = N'current_promo_price',
    @role_name = NULL,
    @supports_net_changes = 1;  	

SELECT name, is_cdc_enabled
FROM sys.databases
WHERE name = 'stellar';

select * from dbo.TICKET;

select * from dbo.current_promo_price_new;
