For java.util.Date, just create a new Date()
```
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
```
For java.util.Calendar, uses Calendar.getInstance()
```
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43
```
For java.time.LocalDateTime, uses LocalDateTime.now()
```
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	System.out.println(dtf.format(now)); //2016/11/16 12:08:43
```
For java.time.LocalDate, uses LocalDate.now()
```
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate)); //2016/11/16
```
