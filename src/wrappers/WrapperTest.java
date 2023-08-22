package wrappers;

public class WrapperTest {

    public static void main(String[] args) {
        // Integer
        Integer int1 = 10;
        Integer int2 = Integer.valueOf(10);
        Integer int3 = new Integer(10);
        Integer int4 = Integer.parseInt("10");

        // Double
        Double double1 = 3.14;
        Double double2 = Double.valueOf(3.14);
        Double double3 = new Double(3.14);
        Double double4 = Double.parseDouble("3.14");

        // Byte
        Byte byte1 = 100;
        Byte byte2 = Byte.valueOf((byte) 100);
        Byte byte3 = new Byte((byte) 100);
        Byte byte4 = Byte.parseByte("100");

        // Short
        Short short1 = 200;
        Short short2 = Short.valueOf((short) 200);
        Short short3 = new Short((short) 200);
        Short short4 = Short.parseShort("200");

        // Long
        Long long1 = 1000L;
        Long long2 = Long.valueOf(1000L);
        Long long3 = new Long(1000L);
        Long long4 = Long.parseLong("1000");

        // Float
        Float float1 = 2.5f;
        Float float2 = Float.valueOf(2.5f);
        Float float3 = new Float(2.5f);
        Float float4 = Float.parseFloat("2.5");

        // Character
        Character char1 = 'A';
        Character char2 = Character.valueOf('A');
        Character char3 = new Character('A');
        Character char4 = 'A';

        // Boolean
        Boolean bool1 = true;
        Boolean bool2 = Boolean.valueOf(true);
        Boolean bool3 = new Boolean(true);
        Boolean bool4 = Boolean.parseBoolean("true");

        // Примітивні типи
        byte b = double1.byteValue();
        short s = double1.shortValue();
        int num = double1.intValue();
        float f = double1.floatValue();
        long l = double1.longValue();

        // Перевірка NaN і Infinity
        Double zero = 0.0;
        Double nanValue = double1 / 0;
        Double infinityValue = zero / zero;

        System.out.println("nanValue = " + nanValue);
        System.out.println("infinityValue = " + infinityValue);

        if (nanValue.isNaN()) {
            System.out.println("Змінна nanValue = NaN");
        }
        if (infinityValue.isInfinite()) {
            System.out.println("Змінна infinityValue = Infinity");
        }

        // Порівняння Long
        Long l1 = 120L;
        Long l2 = 120L;

        System.out.println("l1 == l2: " + (l1 == l2));

        l1 = 1200L;
        l2 = 1200L;

        System.out.println("l1 == l2: " + (l1 == l2));
    }
}
