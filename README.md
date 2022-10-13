# pin-generator

```java
import com.github.pitzzahh.pinGenerator.Pin;
import com.github.pitzzahh.pinGenerator.PinGenerator;
import io.github.pitzzahh.util.utilities.Print.println;

public class Main {
    public static void main(String[] args) {
        // generates a random 10 numbers as pin
        Pin numbersPin = PinGenerator.generatePin(PinGenerator.NUMBERS, 10);
        println(numbersPin);
        // generates a random 10 letters as pin
        Pin lettersPin = PinGenerator.generatePin(PinGenerator.LETTERS, 10);
        println(lettersPin);
        // generates a random 10 mixed letters and numbers as pin
        Pin mixedPin = PinGenerator.generatePin(PinGenerator.MIXED_NUMBERS_AND_LETTERS, 10);
        println(mixedPin);
    }
}
```

### Add Maven Dependency

![maven-central](https://img.shields.io/maven-central/v/io.github.pitzzahh/pin-generator?color=blue)

If you use Maven, add the following configuration to your project's `pom.xml` <br>

Be sure to replace the **VERSION** key below with the one of the versions shown above

```maven
<dependencies>

    <!-- other dependencies are there -->
    <dependency>
        <groupId>io.github.pitzzahh</groupId>
        <artifactId>pin-generator</artifactId>
        <version>VERSION</version>
    </dependency>
    <!-- other dependencies are there -->

</dependencies>
```