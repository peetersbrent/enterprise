# Scheidsrechter
## Beschrijving
Dit project draait om een microservices-backend met het thema scheidsrechter. Ik heb dit thema gekozen omdat ik zelf een scheidsrechter bent.
Het project bestaat uit drie belangrijke microservices namelijk: competitie, scheidsrechter en wedstrijd. Daar vertel ik hieronder meer over.
Het geheel van dit project zorgt voor een efficiënt en flexibel systeem voor het organiseren en uitvoeren van sportevenementen.

## Microservices
De **_Competitie-microservice_** beheert de overkoepelende structuur van een voetbalcompetitie. Hier worden details zoals de provincie, ploegen in de bepaalde competitie, de start en einddatum en de competitieleider bijgehouden. Je kan natuurlijk zoeken per competitie, ook alle competitie in totaal. Je kan een competitie aanmaken maar niet aanpassen. Hier heb ik voor gekozen omdat een competitie elk jaar opnieuw wordt aangemaakt maar doorheen het jaar kan deze niet worden aangepast.

De **_Scheidsrechter-microservice_** is belangrijk en hierin wordt alle informatie met betrekking tot scheidsrechters opgeslagen en beheerd. Het omvat gegevens over de scheidsrechter zoals naam, geboortedatum, email en het niveau waarop hij/zij fluit of vlagt. Ook houd ik bij of de scheidsrechter een assisistent is ja of nee. Je kan natuurlijk zoeken naar een scheidsrechter, ook alle scheidsrechters in totaal. Je kan ook een scheidsrechter aanmaken, bijwerken en verwijderen.

De **_Wedstrijd-microservice_** richt zich op de organisatie van individuele wedstrijden. Hier worden details van de wedstrijd weergegeven zoals het thuis en uitteam, de datum van de wedstrijd, het ID van de scheidsrechter en de score. Ook hier weer kan natuurlijk zoeken naar een wedstrijd, ook alle wedstrijden in totaal. Je kan ook een wedstrijd aanmaken, bijwerken en verwijderen.
## Gateway

## Schema
![enterprise_bp drawio](https://github.com/peetersbrent/enterprise_bp/assets/91012837/c49efaa3-fa35-458e-be81-a73d9c3d791c)

## Werking van endpoints:

### Scheidsrechter
### Wedstrijd
### Competitie

## Hosting 
