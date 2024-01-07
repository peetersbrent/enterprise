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
Een API Gateway is iets dat alles regelt voor microservices. Het ontvangt verzoeken, handelt taken zoals authenticatie af en stuurt het verkeer naar de juiste microservice. Het maakt de communicatie tussen client-apps en microservices eenvoudiger en efficiënter.

## Schema

Dit schema toont de architectuur en interactie tussen verschillende services en databases in een softwaretoepassing. Het illustreert hoe de API-gateway communiceert met andere services zoals "scheidsrechter-service", "competitie-service" en "wedstrijd-service", en hoe deze services op hun beurt verbonden zijn met hun respectievelijke databases.

- **API Endpoints**: Het schema toont verschillende API-endpoints met HTTP-methoden zoals GET, POST, DELETE en hun respectieve paden.
- **API-Gateway**: De "api-gateway" is afhankelijk van en verbonden met drie services: "scheidsrechter-service", "competitie-service" en "wedstrijd-service".
- **Services en Databases**: De "wedstrijd-service" is gekoppeld aan een MySQL-database genaamd “mysql:wedstrijd”. De "scheidsrechter-service" is gekoppeld aan een MySQL-database genaamd “mysql:scheidsrechter”. De “competitie-service” is verbonden met een MongoDB-database genaamd “mongo:competitie”.
- **Configuratie**: Aan de rechterkant van het schema staat aanvullende informatie over de configuratie van de api-gateway, inclusief afhankelijkheden en omgevingsvariabelen. 

Dit schema is een nuttige visuele weergave van hoe de verschillende componenten van de softwaretoepassing met elkaar communiceren. Het helpt bij het begrijpen van de stroom van gegevens en de interacties tussen de verschillende services en databases.

![schema](https://github.com/peetersbrent/enterprise_bp/assets/91012837/f9a60dff-ced5-4d66-a296-61bbe5b0f249)

## Werking van endpoints:

### Scheidsrechter

Op de screenshot hieronder zie je dat ik een scheidsrechter kan opvragen met een bepaalde skuCode.
Je kan natuurlijk ook alle scheidsrechters in één keer opvragen.

![scheidsrechter_all](https://github.com/peetersbrent/enterprise_bp/assets/91012837/df48e7a0-f905-45bc-a07b-cfb42f14186d)
![scheidsrechter_skuCode](https://github.com/peetersbrent/enterprise_bp/assets/91012837/0dd75256-c5ae-4dc9-a2cc-6aa60f4a7ef0)

Op de screenshot hieronder zie je dat ik een scheidsrechter met een skuCode kan verwijderen. 
Daaronder zie je het resultaat dat ik de scheidsrechter met skuCode 2 heb verwijderd.

![scheidsrechter_delete](https://github.com/peetersbrent/enterprise_bp/assets/91012837/848ed65f-87e5-459e-b5a0-cb8e0e0654a4)
![scheidsrechter_delete_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/255ac170-cc7b-457d-889a-06630bf49251)

Op de screenshot hieronder zie je dat ik een scheidsrechter kan aanmaken. 
Daaronder zie je het resultaat dat ik de scheidsrechter daadwerkelijk aanmaak.

![scheidsrechter_post](https://github.com/peetersbrent/enterprise_bp/assets/91012837/7f7f57d3-be02-470d-adb4-afaa1b14655b)
![scheidsrechter_post_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/0da4cb17-4493-4b77-bc0c-ae2c300f5cc7)

Op deze screenshot zie je dat je een scheidsrechter ook kan aanpassen.

![scheidsrechter_put](https://github.com/peetersbrent/enterprise_bp/assets/91012837/cfb9d6da-4481-4d61-b843-98470248ffb2)


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

Op de screenshot hieronder zie je dat ik een competitie kan opvragen met een bepaalde skuCode.
Je kan natuurlijk ook alle competitie in één keer opvragen.

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

Op de screenshot hieronder zie je dat ik een competitie kan opvragen met een bepaalde skuCode via de api-gateway.
Dit wel zonder Authentication.

![api_competitie_skuCode](https://github.com/peetersbrent/enterprise_bp/assets/91012837/bedc3409-561c-478e-bf1a-1e06cacdcd92)

Op de eerste screenshot zie je dat ik geen toegang heb tot een wedstrijd. 
De screenshot daaronder zie je dat ik met een Bearer token wel toegang heb tot wedstrijd.

![api_wedstrijd_NOauth](https://github.com/peetersbrent/enterprise_bp/assets/91012837/aa582c5c-c3c7-436a-9bc6-8e58154078dd)
![api_wedstrijd_auth](https://github.com/peetersbrent/enterprise_bp/assets/91012837/b432f204-8c24-45ef-9147-c6616a484e26)

Op de screenshot hieronder zie je dat ik een scheidsrechter kan aanmaken ook weer beveiligd. 
Daaronder zie je het resultaat dat ik de scheidsrechter daadwerkelijk aanmaak.

![api_scheidsrechter_post_auth](https://github.com/peetersbrent/enterprise_bp/assets/91012837/40050973-3245-412c-b994-5b889eed7422)
![api_scheidsrechter_post_auth_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/1da8946f-a34b-4b6f-a54e-570b0754f50e)

Op deze screenshot zie je dat je een scheidsrechter ook kan aanpassen.
Met daaronder het resultaat.

![api_scheidsrechter_put_auth](https://github.com/peetersbrent/enterprise_bp/assets/91012837/bad8a50e-0943-462d-913c-645b6d4c092d)
![api_scheidsrechter_put_auth_result](https://github.com/peetersbrent/enterprise_bp/assets/91012837/a844d3ec-4cdb-4163-97db-303bf0b1ccc9)

## Hosting 

Okteto: https://cloud.okteto.com/spaces/peetersbrent?resourceId=75d90cf5-4e73-4656-b381-da9058238aa7 
  - Api-gateway: https://api-gateway-peetersbrent.cloud.okteto.net
  - Competitie: https://competitie-service-peetersbrent.cloud.okteto.net
  - Scheidsrechter: https://scheidsrechter-service-peetersbrent.cloud.okteto.net
  - Wedstrijd: https://wedstrijd-service-peetersbrent.cloud.okteto.net
