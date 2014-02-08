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

