OrgaManager
===========

Inhaltsuebersicht
-----------------

* Allgemeines
* Pakete controller, model und view
* Paket Publikationen 
* Entwicklung nach der Clean Code Developer Philosophie 

Allgemeines
-----------

Der OrgaManager ist ein Werkzeug, um diverse anfallende Orgataetigkeiten zu
automatisieren. Es ist als Java-Desktop-Anwendung realisiert und somit auf 
MacOS, Linux und Windows lauffaehig. Fuer die Entwicklung hat sich die Eclipse
Entwicklungsumgebung bewaehrt. Die Entwickler-Dokumentation befindet sich im 
Quelltext, in der Datei README.md stehen weitere Hinweise.

Persistenz passiert mittels properties.xml-Datei und SQLite-Datenbank im Ordner
des Projektes. OmModel.doCreateInvoice() fasst wichtige Schritte zu EclipseLink
und JPA.

Abhaengigkeiten bestehen zu folgenden Bibliotheken/Projekten: 
* EclipseLink (JPA 2.1)
* Selenium 2.39
* SQLite und SQLite-JDBC

Pakete controller, model und view
---------------------------------

Paket Publikationen
-------------------

Entwicklung nach der Clean Code Developer Philosophie
-----------------------------------------------------

Es gibt diverse Grade, bevor man die Grade durchlaeuft sollte man sich mit den
Werten vertraut machen: Evolvierbarkeit, Korrektheit, Produktionseffizienz, 
Reflexion. Evolvierbarkeit bedeutet den Einsatz einer Architektur, die haeufige
Refactorings und stetige Erweiterbarkeit erlaubt. Korrektheit bedeutet, dass man
Tests auf Korrektheit bereits tief in den Entwicklungsprozess verankert. 
Produktionseffizienz ist das geschickte Abwaegen der anderen Werte, wer zu lange
Unit-Tests schreibt, besitzt am Ende auch keine marktfaehige Software. Reflexion
ist notwendig, um einen Lernprozess zu erreichen, hier helfen Code-Reviews oder 
Pair Programming.

Die Befassung mit den Werten und prinzipiellen Tugenden stellt den schwarzen 
Grad dar. Die Tugenden lauten: Schaetze Variation; Tue nur das Noetigste; 
Isoliere Aspekte; Minimiere Abhaengigkeiten; Halte Versprechen ein; Umarme 
Unsicherheit; Fokussiere; Wertschaetze Qualitaet; Mach fertig; Halte Ordnung;
Bleib am Ball - Beispiele, siehe clean-code-developer.de/Tugenden.ashx  

Der rote Grad besitzt einen Theorie und einen Praxisteil. Als Theoriethemen 
sind Don't repeat yourself (DRY); Keep it simple, stupid (KISS); Don't 
preoptimize or develop maybe-soon-relevant-features (YAGNI); Favour composition
over inheritance (FCOI). Als Praxisteil sollte man die Pfadfinderregel anwenden,
dazu die Problemursachen analysieren, statt sich den Symptomen zu widmen. Des 
weiteren sollte man ein Versionskontrollsystem einsetzen, Refactorings anwenden
und jede Session um einen kurzen Review bereichen, etwa den Daily-Review.

Der orange Grad setzt auf die Konzepte des Single Level of Abstraction (SLA), 
Separation of Concerns (SOC), Source Code Conventions (SCC). Als Praxisanregung
sollte man auf Issue Tracking setzen und automatisierte Integrationstests 
fahren. Des Weiteren wird auf das notwendige Lesen von Literatur und auf die 
Code Reviews verwiesen.

Der gelbe Grad ...
Interface Segregation Principle (ISP)
Dependency Inversion Principle (DIP)
Liskov Substitution Principle (LSP)
Principle of least astonishment
Information hiding principle
Auto-Unit-Tests
Mockups
CodeCoverageAnalyse
Fachevents-Besuche
Komplexe Refactorings

Der gruene Grad ...
Open-Closed principle (OCP)
Tell, don't ask
Law of demeter
Continous integration
Metriken
Inversion of control container
Erfahrung weitergeben
Messen von Fehlern

Der blaue Grad ...
Entwurf und Implementierungsinkonsistenzen vermeiden;
Implementation spiegelt den Entwurf;
You ain't gonna need it;
Continous delivery;
Iterative Entwicklung;
Komponentenorientierung;
Test first;

Der weisse Grad ...
Starte wieder beim roten Grad;

