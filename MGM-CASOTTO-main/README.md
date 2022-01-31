# MGM-CASOTTO

Casotto - Gestione Chalet

Il progetto si inserisce nel contesto della realizzazione di uno Chalet smart. In particolare il sistema da realizzare dovrà permettere la completa gestione della spiaggia con prenotazione di ombrelloni nonché sdraio/lettini. La prenotazione di un ombrellone si riferisce alla mezza giornata, alla giornata intera, o a più giorni consecutivi. Il prezzo della prenotazione sarà dipendente da politiche che il gestore dello chalet potrà decidere. In particolare il prezzo può dipendere dalla collocazione dell’ombrellone sulla spiaggia, sulla tipologia dello stesso nonché dal periodo dell’anno. Lo chalet fornisce poi servizio di bar per gli ombrelloni. Il cliente potrà dunque accedere tramite una app al servizio e selezionare i prodotti da acquistare. Successivamente inquadrando il QR code posto sull’ombrellone sarà possibile identificare l’ombrellone in cui i prodotti dovranno essere portati. Per far questo il servizio di spiaggia è dotato di appositi terminali sui quali vengono notificate le richieste emesse dai clienti e che dunque possono essere prese in carico dagli adetti alla spiaggia e dunque soddisfatte. E’ prevista la stampa di uno scontrino al termine della gestione dell’odine che sarà consegnato al cliente.

Lo chalet durante il giorno organizza attività per gli ospiti che possono essere di natura ludico/sportiva. Gli ospiti presenti potranno dunque una volta entrati nello chalet prenotarsi per partecipare alle attività che in alcuni casi possono prevedere un numero massimo di partecipanti. Il sistema permette di notificare i clienti per distribuire i programmi delle attività o eventuali promozioni. E’ possibile inviare messaggi anche soltanto agli ospiti presso la struttura in un dato giorno, ovvero a coloro che in un dato momento risultano assegnatari di un ombrellone. In particolare il sistema invierà un reminder a tutti coloro si siano registrati per una delle attività giornaliere. Il sistema prevedrà ovviamente funzionalità accessibili al gestore al fine di definire le caratteristiche della struttura quali la spiaggia, eventuali attrezzature ludico/sportive, le attività giornaliere e tutto quanto necessario al funzionamento del sistema.

Progetto: Casotto Meccanismo di decisione dei prezzi (fila, tipo di ombrellone,…), quindi meccanismi che definiscano politiche. Servizio al bar per ombrelloni. Con l’app posso ordinare bibite da portare all’ombrellone, inquadrando il qr code sull’ombrellone. Sistema di messaggistica associato alla app, tutti quelli che possono ricevere promozioni o da mandare a tutti quelli che hanno prenotato l’ombrellone. Sistema di prenotazione per attività.

Applicazione web Parte Server: Java (Springboot), DB relazionale Parte front-end: altri strumenti Framework grafico: JavaFx

02/11/2021

Attori Cliente: chi prenota un ombrellone Gestore Organizzatore eventi Ospite: chi partecipa ad eventi (esterno allo chalet) Tempo

Casi d’uso prenotazione ombrelloni/sdraio/lettini/cabina (intera/mezza giornata), pranzo/cena [attore: cliente]; prenotazione campi/attività ludico/sportive [attore: ospite]; gestione politiche, prezzi e promozioni [attore: gestore]; servizio bar, sistema di pagamento (diretto, indiretto, contanti) [attore: cliente]; organizzazione eventi ludico/sportivi, messaggi e notifiche [attore: organizzatore eventi]; modifiche, definizione caratteristiche chalet (struttura, impianti, campi) [attore: gestore]; jukebox [attore: ospite]; sistema di feedback e suggerimenti [cliente/ospite?]

Eventi cliente: può prenotare anche per giorni diversi; ospite: può prenotare solo per quel giorno

09/11/2021

Step 1: descrizione casi d’uso

Caso d’uso: ID: Breve descrizione:

Attori primari:

Attori secondari:

Precondizioni:

Sequenza degli eventi principale:

Postcondizioni:

Sequenza degli eventi alternativa:

Step 2: creazione del diagramma delle classi di analisi (classi astratte, gestori che vengono fuori da processi)

3 schermi: use case modello di dominio sequence diagram
