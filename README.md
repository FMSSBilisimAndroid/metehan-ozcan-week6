# Week-6 Homework

## 1- Coroutine bloğunu kapsayan döngüde bir sayaç yazın.
![1](https://user-images.githubusercontent.com/70481060/193432369-cec2380b-4a6c-4c38-8800-f83dc530fc00.PNG)

## 2- Döngü kilitlenmeye sebep olacak mı ?
* Evet döngü Main thread'i doldurduğu için kilitlenmeye sebep olacak. UI'dan herhangi bir cevap alamayacağız.
<p float="left">
  <img src="https://user-images.githubusercontent.com/70481060/193432403-e0ffc81f-af0c-4d4f-9160-a433d03088d6.PNG" width="70%" height="70%"/>
  <img src="https://user-images.githubusercontent.com/70481060/193432416-8eb8fc13-2986-4923-b310-3dcbc5972086.PNG" width="50%" height="50%"/>
  </p>
  
## 3- Kilitlenmeye sebep olmadan  aşağıdaki blok çalışır mı ?
* Hayır çalışmayacaktır. Main thread bloklu olduğu için Dispatchers.Main'de yazdırmak istediğimiz Log dönmez, aynı işlemi Dispatchers.IO'da data değerini yazdırmak isteseydik geri dönüş alacaktık ancak Main thread her halükarda kilitlenecekti.

![5](https://user-images.githubusercontent.com/70481060/193432624-a82c4c54-eae5-4949-9c79-6d6a8da315bb.PNG)
