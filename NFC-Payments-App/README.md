# NFC Payments App

## Opis projektu
Aplikacja NFC Payments App to zaawansowany system płatności zbliżeniowych oparty na Android HCE.  
Obsługuje:
- Dodawanie kart przez ręczne wprowadzenie danych (numer karty, data, CVV) oraz przez dane Track 2.
- Force Approved – transakcje są zatwierdzane offline bez autoryzacji bankowej.
- Biometryczna autoryzacja przed płatnością.
- Szyfrowanie danych przy użyciu Android Keystore.

## Struktura projektu
- `app/src/main/AndroidManifest.xml` – Manifest aplikacji
- `app/src/main/java/com/example/nfcapp/` – Kod źródłowy w Kotlinie
  - `NFCService.kt` – Obsługa NFC (HCE)
  - `ForceApproved.kt` – Logika Force Approved
  - `CardManager.kt` – Zarządzanie kartami
  - `BiometricAuth.kt` – Autoryzacja biometryczna
- `app/build.gradle` – Konfiguracja modułu
- `settings.gradle` oraz `build.gradle` – Konfiguracja projektu

## Instalacja i budowanie
1. Sklonuj repozytorium:
