# Mandatory 4

## Deloppgave 1: Prosjekt og prosjektstruktur
* Testrollen har vi valgt at kundekontak Hein skal ha, siden han er den som har jobbet mest med koden per dags dato. 
Han har også direkte kontakt med kunden og vil kunne dele oppgaver ut i fra det kunden ønsker. Vi har manuelle tester, 
disse finner man beskrevet på wikien vår [produksjonsprosedyre](https://github.com/inf112-v19/YellowBots/wiki/Produksjonsprosedyre).
Minner om at ikke alle punktene på lista er relevante enda da vi ikke er ferdig med alle kravene. 

* Vi har jo nå jobbet sammen som gruppe over lengere tid, og da er det klart man får erfaringer som blir viktig kunnskap
for videre utvikling. Blant annet har vi erfart at det og jobbe som gruppe på et så stort prosjekt kan være spennende, 
utfordrende og frustrerende. Teamet er samstemt på at vi fortsatt ligger ganske langt bak, det man hadde sett for seg på 
ønsket tidspunkt. Mye av dette skyldes rett og slett at vi som team har vært dårlig på å gi "*hjemmelekser*", altså at man 
arbeider på egenhånd på fritiden med oppgaver som skal bli gjort. Dette er en veldig viktig erfaring vi har gjort, for 
ønsker vi at prosjektet skal bli som vi hadde ønsket, og ikke et uferdig spill, må vi begynne å gjøre ting oftere på fritiden
og ikke bare når vi har gruppetimer. Utenom dette er gruppen veldig fornøyd med valgene som er blitt tatt. 

* Selve gruppedynamikken fungerer utmerket. Vi er en veldig sammensatt gruppe, med ulike personligheter og kunnskapsnivå.
Selvfølgelig er det slik at noen på gruppen kan mer enn andre, men at vi er veldig flink til å forklare og hjelpe hverandre
slik at alle er på bølgelengde. Det viktigste for oss er at alle skal få presentere sine forslag og løsninger, også er 
det gjennom diskusjoner og testing som bestemmer hvilken vei vi ønsker å gå videre i prosjektet. 

* Kommunikasjonen i gruppen fungerer veldig bra. Vi bruker fortsatt *slack* til å avtale møter, diskutere småting og søke 
hjelp om det er noe vi lurer på. Men det meste av kommunikasjon mellom gruppen skjer i gruppetimer og når gruppen har avtalt
og møtes. Da har vi muligheten til å parprogrammere, men vi kan også snakke med alle andre på gruppa om ting vi gjør. 
Det er naturligvis enklere å få hjelp fra resten av gruppa når man er samlet og kan utveksle erfaringer og kunnskap. 

* Vi har klart å få laget et spillebrett, en spiller som kan interagere med brettet, rullebånd, maploader og vi har kommet 
veldig godt i gang med kortene. Tidligere hadde vi veldig stort fokus på coverage siden vi lå veldig langt bak akkurat der, men nå er 
fokuset vårt innrettet mot å få noe som ligner på et roborally-spill. Vi jobber som regel veldig godt når vi møtes, men vi 
jobber veldig sjeldent én og én på litt større deler av prosjektet. Vi foretrekker å programmere i par på større deler av koden, 
slik at produksjonskvaliteten blir bedre. Dette igjen gjør jo at ting tar litt mer tid, fordi man bruker mer ressurser på 
kun det ene området. Men vi føler gevinsten av dette er større enn "kostnaden".

* **Tre forbedringspunkter**

1. Vi må være flinkere til å gjøre ting på fritiden, og ikke bare når vi møtes. 

2. Vi må fortsette med effektivisering av arbeid, slik at vi har mulighet til å bli ferdig med prosjektet og at vi blir 
fornøyd. 

3. Kodekvalitet og coverage må opp et lite hakk igjen, coverage har gått litt ned siden vi hadde veldig mye fokus på det, 
også lot vi det ligge en stund og nå må vi begynne å fokusere på det igjen. 


* Alle våre referater ligger i **meeting minutes**. Referatene som er skrevet siden sist innlevering starter fra `20190312-0.md`
 til `20190401-0.md` (sist endret 01/04/2019, kan komme flere referater før innlevering)
 

* Vi kommer til å løse dette ved at de som har gjort minst kodemessig, prøver å kode først på egenhånd det som skal implementeres
men at vedkommende har mulighet til å få hjelp og veiledning av de som har jobbet mest med koden. Vi ønsker at alle skal 
bidra med koden, og da er det viktig at vi gir alle muligheten til det, selvom forutsetningene ikke er de samme for alle. 
For eksempel kan parprogrammering være en løsning, bare at den som har jobbet mest sitter med maskinen og er den som skriver koden
mens parkameraten kommer med innspill og eventuelle forbedringspunkter til det som er blitt gjort. Dette blir vanskelig å jevne helt ut 
før leveringen av obligen, men frem til neste oblig vil dette være et viktig punkt for oss. 

* Link til vår prosjekttavle på trello [prosjekttavle yellowbots](https://trello.com/b/XBCcTKDN/gult-er-kult)

## Deloppgave 2: Krav 
Siden vi ikke har oppnådd **MVP** enda, så dette vil være vårt hovedfokus fremover.

* Vi ønsker å implementere muligheten til å spille en runde. Dette er noe vi har lyst til å få til i nær fremtid. Når 
man har klart denne funksjonen er man godt i gang.

* Lasere på brettet: Vi har laget implementasjonen av lasere. Vi kan også legge de til på brettet. Per dags dato 
kan ikke lasere acte på brettet

* Det skal være hull på brettet: Vi har hull på brettet og hvis man havner i et hull, kommer man seg ikke videre. I teorien
skal man egentlig dø, men det skjer foreløpig ikke hos oss. 

* Skademekanismer: Som nevnt litt lengere opp har vi ikke helt implementert disse mekanismene. Men dette kan vi gjøre ganske raskt
og det kan hende at vi legger det til før obligen skal leveres. Men da bare i enkelte tilfeller.

* Fungerende samlebånd på brettet: Dette er en funksjon vi så si er ferdig med å implementere. Men vi har enda ikke lagt til
funksjonen på brettet, da vi føler det er andre ting som bør prioriteres foreløpig. 

* Game over etter 3 tapte liv: Dette kommer vil til å fikse når vi har rundelogikken på plass. Vi har fikset slik at roboten tar skade
men ikke at den mister liv hvis den har tatt nok skade. Men som sagt så må rundelogikken på plass først, før vi kan begynne med
"*game over*"

* Multiplayer over LAN og internett: Dette er noe vi har veldig lyst å få implementert, men dette er ikke veldig høyt prioritert
per dags dato. Dete er mye viktigere for oss å få et noenlunde fungerende spill før vi begynner med flerspiller-funksjoner

* Power down: Dette er et krav vi kommer til å vente ganske lenge med før vi implementerer det, da dette kun er en liten feature
og *MÅ* ikke implementeres på nåværende tidspunkt.

* Samlebånd med dobbelt tempo: Dette er også noe vi har implementert men ikke enda lagt inn på brettet. Vi har prøvd å legge 
det til på brettet og fikk noen små bugs som vi må få fikset etterhvert

* Options-kort: Dette er kanskje det vi har jobbet mest med siden forrige oblig. Vi har implementert kortene, men foreløpig 
utfører de ingenting. Vi jobber med at de skal utføre noe når de blir brukt, så får vi se om dette er noe vi rekker før 
innleveringsfristen 01/04/2019

* Plassere flagg selv før spillet starter: Hvis vi ønsker så kan vi legge til flagg, men siden vi mangler en komplett rundelogikk
så blir det vanskelig for oss å legge det til *før spillet starter*

* Sette sammen ulike brett til større spillflate: Dette er ikke noe vi har implementert enda, men man kan faktisk lage sine egne brett
i mapeditoren. 

* Spille mot AI: Dette er noe vi naturligvis kommer til å drøye foreløpig. Vanskelig å lage en fungerende AI
når man ikke har et spill som  fungerer optimalt. 

Fra de mer frie kravene, har vi implementert muligheten til å lage og generere brett. Dette ved hjelp av mapeditoren. 

**Krav vi har prioritert** 
* Options-kort og programtkort 
* Opprettholde coverage
* Grafikk til flere feautres (Samlebånd, kort etc.)
* Lage en dynamisk tilefactory for å forbedre utvikling samtidig som det forhindrer kodekollisjon. 

**Hvor langt har vi kommet siden sist?** 
* Vi har fått gjort ganske mye siden sist innlevering. Vi har fått implementert veldig mange features/krav, som vi ikke hadde 
på den forrige innleveringen. Blant annet så begynner kortene endelig å komme på plass. Før innleveringen nå, jobber vi med
å få kortene inn i selve spillet. Vi har også fått laget en dynamisk tilefactory, som forbedrer utviklingen vår massivt
når det kommer til testing av tiles. 


## Deloppgave 3: Kode
* For instrukser til bygging av prosjektet se [GitHub-Readme](https://github.com/inf112-v19/YellowBots#how-to-buildcompile). 
*Obs: krever Java 11*

Under **"Compatible OS"** i README, kan man lese hvordan prosjektet skal funke på de ulike operativsystemene.

Ønsker man mer informasjon om vår bygg-server, se her: [Jenkins-byggeserver](https://github.com/inf112-v19/YellowBots/wiki/ByggeServer)
                                                   

## Klasse-diagram 


## Tilleggsinformasjon 
Vi har støtt på flere utfordringer på veien. Disse utfordringene legger vi til i issues på wikien vår, slik at vi kan "lære
av våre feil" og kanskje andre kan se hvordan vi har løst enkelte problemer. Disse finner man her: [Issues](https://github.com/inf112-v19/YellowBots/wiki/Issues)
