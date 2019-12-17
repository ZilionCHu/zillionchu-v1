package com.zillionchu.common.utils.id;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.time.FastDateFormat;

import java.net.NetworkInterface;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-08-13 16:18
 * @Description:
 */
public class UniqueKeyGenerator {

    private static final char[] HEX_CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte int3(final int x) {
        return (byte) (x >> 24);
    }

    public static byte int2(final int x) {
        return (byte) (x >> 16);
    }

    public static byte int1(final int x) {
        return (byte) (x >> 8);
    }

    public static byte int0(final int x) {
        return (byte) (x);
    }

    private static final int MACHINE_IDENTIFIER = createMachineIdentifier();

    public static int getMachineIdentifier() {
        return MACHINE_IDENTIFIER;
    }

    private static final FastDateFormat TIMESTAMP_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");
    private static final AtomicInteger counter = new AtomicInteger(new SecureRandom().nextInt());
    private static final Joiner KEY_JOINER = Joiner.on("-");


    public static String generate(Object... args) {

        String hexIdString =
                toHexString(toByteArray(Objects.hash(args), getMachineIdentifier(),
                        counter.incrementAndGet()));

        return KEY_JOINER.join(TIMESTAMP_FORMAT.format(new Date()), hexIdString);

    }

    /**
     * Concat machine id, counter and key to byte array
     * Only retrieve lower 3 bytes of the id and counter and 2 bytes of the keyHashCode
     */
    protected static byte[] toByteArray(int keyHashCode, int machineIdentifier, int counter) {
        byte[] bytes = new byte[8];
        bytes[0] = int1(keyHashCode);
        bytes[1] = int0(keyHashCode);
        bytes[2] = int2(machineIdentifier);
        bytes[3] = int1(machineIdentifier);
        bytes[4] = int0(machineIdentifier);
        bytes[5] = int2(counter);
        bytes[6] = int1(counter);
        bytes[7] = int0(counter);
        return bytes;
    }

    public static String toHexString(byte[] bytes) {
        char[] chars = new char[bytes.length * 2];
        int i = 0;
        for (byte b : bytes) {
            chars[i++] = HEX_CHARS[b >> 4 & 0xF];
            chars[i++] = HEX_CHARS[b & 0xF];
        }
        return new String(chars);
    }

    private static int createMachineIdentifier() {
        // build a 2-byte machine piece based on NICs info
        int machinePiece;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();

            if (e != null) {
                while (e.hasMoreElements()) {
                    NetworkInterface ni = e.nextElement();
                    sb.append(ni.toString());
                    byte[] mac = ni.getHardwareAddress();
                    if (mac != null) {
                        ByteBuffer bb = ByteBuffer.wrap(mac);
                        try {
                            sb.append(bb.getChar());
                            sb.append(bb.getChar());
                            sb.append(bb.getChar());
                        } catch (BufferUnderflowException shortHardwareAddressException) { //NOPMD
                            // mac with less than 6 bytes. continue
                        }
                    }
                }
            }
           // System.out.println(sb.toString());
            machinePiece = sb.toString().hashCode();
        } catch (Throwable ex) {
            // exception sometimes happens with IBM JVM, use random
            machinePiece = (new SecureRandom().nextInt());

        }
        return machinePiece;

    }


    public static void main(String[] args) {
        //20190813165050-c1716357cb797489
        //20190813165319-35326357cb46a134
        // System.out.println(UniqueKeyGenerator.generate("tom"));
        // System.out.println("a".hashCode());
        //SimpleDateFormat
//        for (int i = 0; i < 20; i++) {
//            Random r = new Random();
//            System.out.println(r.nextInt(10));
//        }

        try {
            System.out.println(SecureRandom.getInstance("SHA1PRNG").nextInt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }


}