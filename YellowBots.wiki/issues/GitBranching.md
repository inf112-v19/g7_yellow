Date: 2019-26-02

## Hva skjedde
Vi oppdaget litt for sent at den lille branchen med "simplegraphics" ikke ble merget inn i master, men heller ble brukt til å implementere flere endringer.
Noe som nå har ført til at flere jobber på samme branch med ulike problemer. Dette skaper litt interferens og forsinkelser i videre utvikling.

## Hvorfor skjedde dette
Dette har delvis oppstått grunnet missforståelser og iver etter å implementere nye features, men hovedproblemet ligger i git-kunnskaper. Dette ville fint vert unngått
dersom nye features ble laget i nye brancher. Dette kunne vert gjort med brancher som har roten i "simplegraphics" dersom en ikke ønsker å vente til de har blitt
merget inn i master.

## Hvordan ordnet vi problemet
Problemet ble oppdaget på et tidspunkt hvor vi snart kan merge branchen inn til master. Vi venter dermed til de siste små problemene er løst og slipper dette inn
i master. Vi sletter da branchen, og alle videre endringer vil da få egne branches.

## Hvordan unngår vi dette i fremmtiden
Vi har også tatt dette opp under et møte, og teamet har nå en bedre forståelse av hvordan vi skal unngå dette i fremmtiden med bruk av flere små feature brancher.
Vi har også dokumenter dette på Wiki i håp om ikke å glemme dette.
