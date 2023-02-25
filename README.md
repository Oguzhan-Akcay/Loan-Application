# Loan-Application
# DefineX_Java_Spring_Practicium_Final_Task

### Features
- Sisteme yeni kullanıcılar tanımlanabilir, mevcut müşteriler güncellenebilir veya silinebilir.
- Kredi skoru 500’ün altında ise kullanıcı reddedilir. (Kredi sonucu: Red)
- Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 5000 TL’nin altında iseKullanıcının kredi başvurusu onaylanır ve kullanıcıya 10.000 TL limit atanır. (Kredi Sonucu: Onay). Eğer teminat vermişse teminat bedelinin yüzde 10 u kadar tutar kredi limitine eklenir.
- Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 5000 TL ile 10.000TL arasında ise kullanıcının kredi başvurusu onaylanır ve kullanıcıya 20.000 TL limit atanır. (Kredi Sonucu:Onay) Eğer teminat vermişse teminat bedelinin yüzde 20 si kadar tutar kredi limitine eklenir.
- Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 10.000 TL’nin üstünde ise kullanıcının kredi başvurusu onaylanır ve kullanıcıya AYLIK GELİR BİLGİSİ * KREDİ LİMİT ÇARPANI/2 kadar limit atanır. (Kredi Sonucu:Onay) Eğer teminat vermişse teminat bedelinin yüzde 25 i kadar tutar kredi limitine eklenir.
- Kredi skoru 1000 puana eşit veya üzerinde ise kullanıcıya AYLIK GELİR BİLGİSİ * KREDİ LİMİT ÇARPANI kadar limit atanır. (Kredi Sonucu: Onay) Eğer teminat vermişse teminat bedelinin yüzde 50 si kadar tutar kredi limitine eklenir.
- Kredinin neticelenmesi sonucunda ilgili başvuru veritabanına kaydedilir. Daha sonrasında ise ilgili telefon numarasına bilgilendirme SMS’i gönderilir ve endpoint’ten onay durum bilgisi (red veya onay), limit bilgisi dönülür.
- Gerçekleştirilmiş bir kredi başvurusu sadece kimlik numarası ve doğum tarihi bilgisi ile sorgulanabilir. Doğum tarihi ve kimlik bilgisi eşleşmezse sorgulanamamalıdır. 
- Notlar: Kredi limit çarpanı varsayılan olarak 4’tür.
## Diagram
![diagram](https://user-images.githubusercontent.com/101995377/221354056-06cee3cb-4472-4679-a507-3284a73d5210.png)


## REST API
![Register](https://user-images.githubusercontent.com/101995377/221353969-d3290d48-7fad-41cb-ade4-7d1f9245317e.png)
![Login](https://user-images.githubusercontent.com/101995377/221353975-55ff7b19-e5c6-4b69-b49e-a21e1780fb39.png)
![Update](https://user-images.githubusercontent.com/101995377/221353979-25902cf5-0ddb-486f-b3be-a60b8bde3298.png)
![Delete](https://user-images.githubusercontent.com/101995377/221353980-ae2b3b57-b2de-4447-aa93-b223197a0abe.png)
![AddCredit](https://user-images.githubusercontent.com/101995377/221353982-12b5428c-97e9-44c3-83a9-8bc9d2170bdb.png)
![MakeAnApplication](https://user-images.githubusercontent.com/101995377/221353987-4773c61e-8ef2-4f52-a1e6-b032d735931b.png)

## Installation

```sh
git clone https://github.com/oguzhan3950/Loan-Application.git
```
