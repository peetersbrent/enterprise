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
Op de screenshot hieronder zie je dat ik een scheidsrechter met een skuCode kan verwijderen. 
Daaronder zie je het resultaat dat ik de scheidsrechter met skuCode 2 heb verwijderd.

![scheidsrechter_delete](https://github.com/peetersbrent/enterprise_bp/assets/91012837/848ed65f-87e5-459e-b5a0-cb8e0e0654a4)
![scheidsrechter_delete_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/255ac170-cc7b-457d-889a-06630bf49251)

### Wedstrijd

Op de screenshot hieronder zie je dat ik een wedstrijd kan opvragen met een bepaalde skuCode.
Je kan natuurlijk ook alle wedstrijden in één keer opvragen.

![wedstrijd_all](https://github.com/peetersbrent/enterprise_bp/assets/91012837/08c693fb-1398-4323-8097-bc74ef6c1e20)
![wedstrijd_skuCode](https://github.com/peetersbrent/enterprise_bp/assets/91012837/1271aa2a-91b0-4205-82c2-6200a0793814)

Op de screenshot hieronder zie je dat ik een wedstrijd met een skuCode kan verwijderen. 
Daaronder zie je het resultaat dat ik de wedstrijd met skuCode 5 heb verwijderd.

![wedstrijd_delete](https://github.com/peetersbrent/enterprise_bp/assets/91012837/d43f3f22-6150-4149-be7d-8a0d51b9067c)
![wedstrijd_delete_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/fcd88831-b3d3-418f-9bbc-16f5c75cdcfa)

Op de screenshot hieronder zie je dat ik een wedstrijd kan aanmaken. 
Daaronder zie je het resultaat dat ik de wedstrijd daadwerkelijk aanmaak.

![wedstrijd_post](https://github.com/peetersbrent/enterprise_bp/assets/91012837/2fdfb667-1e04-472b-a911-5c42a80198eb)
![wedstrijd_post_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/e04e9484-6375-42da-a138-1b412b172f22)

Op deze screenshot zie je dat je een wedstrijd ook kan aanpassen.

![wedstrijd_put](https://github.com/peetersbrent/enterprise_bp/assets/91012837/98f03b51-d3ae-40d3-b7cd-8b4106964369)

### Competitie

Op de screenshot hieronder zie je dat ik een wedstrijd kan opvragen met een bepaalde skuCode.
Je kan natuurlijk ook alle wedstrijden in één keer opvragen.

![competitie_all](https://github.com/peetersbrent/enterprise_bp/assets/91012837/9a21000e-9466-4bbb-9b7f-af099c401822)
![competitie_skuCode](https://github.com/peetersbrent/enterprise_bp/assets/91012837/55c471ae-61c2-454b-94bc-5ec6bb7f8d0f)

Op de screenshot hieronder zie je dat ik een competitie met een skuCode kan verwijderen. 
Daaronder zie je het resultaat dat ik de competitie met skuCode 4 heb verwijderd.

![competitie_delete](https://github.com/peetersbrent/enterprise_bp/assets/91012837/8d6d0344-f76d-4375-b3fa-f090b5f0b52a)
![competitie_delete_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/e7a752a2-2aa7-4dc2-8840-5497f81d0113)

Op de screenshot hieronder zie je dat ik een competitie kan aanmaken. 
Daaronder zie je het resultaat dat ik de competitie daadwerkelijk aanmaak.

![competitie_post](https://github.com/peetersbrent/enterprise_bp/assets/91012837/ea0561f1-4f49-467e-91a4-22ef648ca48b)
![competitie_post_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/cd6e17d2-61e9-4c3c-909d-5265eb87a99d)

### Api-gateway (Google Cloud Platform 0Auth2)
![api_competitie_skuCode](https://github.com/peetersbrent/enterprise_bp/assets/91012837/bedc3409-561c-478e-bf1a-1e06cacdcd92)
![api_wedstrijd_auth](https://github.com/peetersbrent/enterprise_bp/assets/91012837/b432f204-8c24-45ef-9147-c6616a484e26)
![api_wedstrijd_NOauth](https://github.com/peetersbrent/enterprise_bp/assets/91012837/aa582c5c-c3c7-436a-9bc6-8e58154078dd)

## Hosting 
