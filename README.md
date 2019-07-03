# SMWBackend
Backend für das SmartWorkbench Projekt

Die Kommunikation des Backend mit dem Frontend erfolgt über eine REST-API.

URI des Webservice: 
    http://46.237.197.145:8080/Backend/webresources/instructions

Eine entsprechende GET-Anfrage an die URI liefert die Baupläne im JSON Format.

---

Eine PUT Anfrage den Webservice dient dazu, dass das Frontend Benutzeraktionen an das Backend weiterleiten kann. 
Der PUT Anfrage kann ein Parameter 'step' hinzugefügt werden um die Aktionen weiterzuleiten. 

Übersicht der PUT-Anfragen:

    - Start der Montage der Zahnbürste:
      http://46.237.197.145:8080/Backend/webresources/instructions?manual=Zahnbuerste?step=1
    
    - Start der Montage der Schraubzwinge: 
      http://46.237.197.145:8080/Backend/webresources/instructions?manual=Schraubzwinge?step=1

Das Backend regelt entsprechend die Montage der Bauteile und steuert die Kommunikation mit den PIs.

### Topics ###
**Wichtig: Die Topics haben kein _/_ am Anfang, da das nur ein unnötiges Level hinzufügt (https://www.hivemq.com/blog/mqtt-essentials-part-5-mqtt-topics-best-practices/)**
##### Datenfluss Pi -> Backend #####
```
smw/workbench_id/pi_id/led/
smw/workbench_1/pi_1/led/
```

##### Datenfluss Pi -> Backend #####
```
smw/workbench_id/pi_id/pir/
smw/workbench_1/pi_1/pir/
```

### Payload ###
Als Nachrichten werden stets JSONs verschickt, da diese eine Struktur mit sich bringen und die Schnittstelle so besser erweiterbar bleibt.

```javascript
{
  status: "blink",
  color: "yellow"
}

{
  motionDetected: true
}
```