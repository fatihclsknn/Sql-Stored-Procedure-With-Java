# Sql-Stored-Procedure-With-Java
	

<img width="1429" alt="Ekran Resmi 2023-06-23 02 18 30" src="https://github.com/fatihclsknn/Sql-Stored-Procedure-With-Java/assets/77187218/2ea1d621-3834-4981-b3f8-70fcd69c53e7">




<img width="1429" alt="Ekran Resmi 2023-06-23 02 18 42" src="https://github.com/fatihclsknn/Sql-Stored-Procedure-With-Java/assets/77187218/7c65d76c-7757-4b48-a485-bf4fd6e7c279">




<img width="1429" alt="Ekran Resmi 2023-06-23 02 18 49" src="https://github.com/fatihclsknn/Sql-Stored-Procedure-With-Java/assets/77187218/7093e10d-58af-480e-ae58-dd1fd7150220">



- Tablolar
		- Branch 
			- branchId -> PK
		- Customer
			- customerId -> PK
		- Account 
			- accountId -> PK
			- customer ve account tablosu arasında 1-n ilişki bulunur -> FK
		- Address 
			- addressId -> PK
			- customer ve address tablosu arasında 1-n ilişki bulunur -> FK
		- Contract 
			- contractId -> PK
			- customer ve contract tablosu arasında 1-n ilişki bulunur -> FK
- status -> A veya P
			- version -> 1’den başlar
			- createdDate -> Tarih/Saat
			- modifiedDate -> Tarih/Saat
	- SP’ler
		- Branch save, update, get, list, delete
		- Customer save, update, get, list, delete
		- Account save, update, get, list, delete
		- Contract save, update, get, list, delete

	- Endpoint’ler
		- branches/
		- customers/
		- customers/(customerId)/address
		- customers/(customerId)/contracts
