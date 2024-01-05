# Scheidsrechter
## Beschrijving
Dit project draait om een microservices-backend met het thema scheidsrechter. Ik heb dit thema gekozen omdat ik zelf een scheidsrechter bent.
Het project bestaat uit drie belangrijke microservices namelijk: competitie, scheidsrechter en wedstrijd. Daar vertel ik hieronder meer over.
Het geheel van dit project zorgt voor een efficiënt en flexibel systeem voor het organiseren en uitvoeren van sportevenementen.

## Microservices
De Competitie-microservice beheert de overkoepelende structuur van een voetbalcompetitie. Hier worden details zoals de provincie, ploegen in de bepaalde competitie, de start en einddatum en de competitieleider bijgehouden. Je kan natuurlijk zoeken per competitie, ook alle competitie in totaal. Je kan een competitie aanmaken maar niet aanpassen. Hier heb ik voor gekozen omdat een competitie elk jaar opnieuw wordt aangemaakt maar doorheen het jaar kan deze niet worden aangepast.

De Scheidsrechter-microservice is het kloppende hart van het project, waarin alle informatie met betrekking tot scheidsrechters wordt opgeslagen en beheerd. Het omvat gegevens over beschikbaarheid, toewijzingen aan specifieke wedstrijden en beoordelingen van prestaties. Deze microservice optimaliseert het proces van scheidsrechtertoewijzing en evaluatie, wat bijdraagt aan een eerlijke en professionele uitvoering van sportevenementen.

De Wedstrijd-microservice richt zich op de organisatie en monitoring van individuele wedstrijden. Hier worden details zoals teamsamenstelling, wedstrijdtijden en locaties vastgelegd. Deze microservice helpt bij het stroomlijnen van het wedstrijdbeheer, zodat alles soepel verloopt vanaf de planning tot aan de uiteindelijke afsluiting van de wedstrijd.
## Gateways

## Schema
![enterprise_bp drawio](https://github.com/peetersbrent/enterprise_bp/assets/91012837/c49efaa3-fa35-458e-be81-a73d9c3d791c)

## Werking van endpoints:

### Scheidsrechter
### Wedstrijd
### Competitie

## Hosting 
