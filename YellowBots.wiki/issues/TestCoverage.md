Date: 2019-28-02

## Hva skjedde
Etter det som så ut som en god Pull request feilet plutselig bygget etter merge til master. Dette viste seg å være grunnet egne strenge krav til Test-Coverage. 
Vi ble enige om å annse dette som en "false positive" da vi føler at å sette slike krav er strengt såpasse tilig i prosjektet.

Bygg: [Bygg nr 76](https://build.raknoel.no/job/RoboRally/76/)

## Hvorfor skjedde dette
Til syvende og sist fordi vi ikke møtte våre egne forventninger til testing.

## Hvordan ordnet vi problemet
Vi har valgt å foreløpig slå av denne sjekken, imens vi nå dedikert jobber mot å bedre coverage.

## Hvordan unngår vi dette i fremmtiden
Dette burde absolutt vert sjekket før det ble lagt til i master. Teamet er informert om problemet og vi prøver å legge til samme sjekken i pull-request førtst.
