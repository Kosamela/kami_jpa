Dopisac zapytanie JPQL ktore wyszuka doktorow badajacych danego pacjenta pomiedzy danymi datami, oraz test. Nie uzywac JpaRepository, czyste JPQL z implementacja taka jak AddressDao
Dopisac serwis ktory bedzie realizowal update dla doktora w sposob kompleksowy, tzn.:
Update pola w encji doktor + test integracyjny
Dodanie wizyty poprzez update encji doktora (kaskady) + test integracyjny
Edycja wizyty przez update encji doktora + test integracyjny
Wejsciem dla serwisu jest TO doktora z lista TO wizyt. Trzeba to odpowiednio pomapowac, polaczy z baza i wyslac tylko jedna komende update do bazy (przed DoctorDao.update / merge)
