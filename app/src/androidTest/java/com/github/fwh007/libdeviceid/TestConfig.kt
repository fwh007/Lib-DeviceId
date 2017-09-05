package com.github.fwh007.libdeviceid

/**
 * Created by Winter on 2017/8/29 0029.
 */
class TestConfig {
    companion object {
        val RSA_PRIVATE_KEY = """
            MIIEpAIBAAKCAQEAwNYelgAsW/T/6BcpSlaWuAdpZrCUTPblH/cgsFwaoPyK4HoU
            TsbwahlgCxE/lXHO59F0oY5yR50Mj0sMmSXHt7CB/AafVlO4//SWaTX1Uy1Bfb8p
            BM2Qb5jd9Bj8BajIAQy93IKyBE2kkhoAfoJ855wMX1kv52p1URRht8bzI9k1uXGw
            V7WWFLXSkL2ePJAvkhgoMJ2Kvp5bqivD7riG2bL2EUsHxJm78X7yHhAf2M4vUrdu
            c1KW0/1nkIf6qL4563RHdLT5Fr8KeJZ5fMDs8erDuMHiOzcVMG7VB3Y9V+g/X4vG
            bdQC57MsJfRb1aKrClpiqNFg5yv/NPw5stmfwQIDAQABAoIBAG5SkdETbE13z2iC
            x7al7zh91QlRAKc/oTo2clczenCbywA+F5wyKJ0qw03RomTnZY4uwOEk07Cw4tyf
            /Sco/CfVLah4SXRkFbUpw1uR6Taa75r3YIpE6NtPw7vBB35dX39qQL0FcL8RhJOp
            mJrIIJmJJ3LtXYCx4UhvtrAjfDsHLMlymMznEHePygLZhvVkJG+E04MRG+CipySR
            kPQu3DcNRdpv4mP9DdZwCbRzuRQ9n5vGZkd7qZCWMwx8R3+uQ6zgjFtmxUSedKJG
            /pq3Rjkf9Xl8L32VjUJM9kMxk+/g127bNJZpjrpBJqlV0lyRbm5KSYpfSdLwg9Hn
            aKNuztkCgYEA73zTmbnrRSN6svjTnR3u7eE5t7hm+hObFfBnWDyi3/VYpURtrhKg
            R5QDnlda4iVdWo2LUfvOvo+jXcd0NRD1h2T2uBsPXy4E+ChZADgFLcaYWlrJVYYw
            1uHuBocWAZx1zpQzjFMCt8t2jOE2YEJZJXX+fRpcP4gf+E+xD+EZxX8CgYEAziHb
            X2PZ0cqgA2dwrSjEuJ5+XaAtuToF/cew6QOYe5PJ6n6+Q8dq2eW8w3YadXvmIhCF
            /c+e7iC2YRuaJGrG6bMS/13i0/Z+VXBfxTV0JPtnSWq9uolfzd49WDPg+EcVQpKM
            BrHAQdbol+6kCg+pvtNK15UWpYAhyeTELMNfur8CgYEAhXXAzghn7i2pcRdthj9q
            KTK8YX/oEzDd2koQrYGNGtW1QtRxcvJ6U6lOouz3ftNnxNDgdR2ox1VwqxA92FzN
            F1jSjSK3XElfB5QklRSi/jGQMboqPPj9OqLJbOXXA6rXk/nPCEIyX46JUFUpYldX
            KqMo4TrRca5Acrama7z8Ca0CgYASSJSBuISYhCV/R8yJv2T7jytcOJn1pPzlDrJV
            aLk8tNYjE4zizCxhGWyN1crxAsVd3iNUaPcK3iHvKRiaBFKSZgzYU8aL0IBSKb6E
            6oHbyeTWcT5U7lxuETlVunxI6V0sY31CFsAb1ukYmNU6AzumLm2kA5hXo67bjowM
            AGRcVwKBgQCby3FhBRnlWpm0gLOHHirWPJyr18WCUxRXLZbqdylVTuD8b7WRdLdz
            TeOCIlJ8Pu7PWwj8Q4LvPI+nzO+BMEqH0J+apvkbicRL0xfE+VJDMjKyqlQOzr2T
            8XMfTdciv0z6w1QR/+uvlcZ5ANuA9AnVyV4hBJo7BIz8x47Htj9kkQ==
            """
//        val RSA_PRIVATE_KEY = "MIIEpAIBAAKCAQEAwNYelgAsW/T/6BcpSlaWuAdpZrCUTPblH/cgsFwaoPyK4HoU\n" +
//                "TsbwahlgCxE/lXHO59F0oY5yR50Mj0sMmSXHt7CB/AafVlO4//SWaTX1Uy1Bfb8p\n" +
//                "BM2Qb5jd9Bj8BajIAQy93IKyBE2kkhoAfoJ855wMX1kv52p1URRht8bzI9k1uXGw\n" +
//                "V7WWFLXSkL2ePJAvkhgoMJ2Kvp5bqivD7riG2bL2EUsHxJm78X7yHhAf2M4vUrdu\n" +
//                "c1KW0/1nkIf6qL4563RHdLT5Fr8KeJZ5fMDs8erDuMHiOzcVMG7VB3Y9V+g/X4vG\n" +
//                "bdQC57MsJfRb1aKrClpiqNFg5yv/NPw5stmfwQIDAQABAoIBAG5SkdETbE13z2iC\n" +
//                "x7al7zh91QlRAKc/oTo2clczenCbywA+F5wyKJ0qw03RomTnZY4uwOEk07Cw4tyf\n" +
//                "/Sco/CfVLah4SXRkFbUpw1uR6Taa75r3YIpE6NtPw7vBB35dX39qQL0FcL8RhJOp\n" +
//                "mJrIIJmJJ3LtXYCx4UhvtrAjfDsHLMlymMznEHePygLZhvVkJG+E04MRG+CipySR\n" +
//                "kPQu3DcNRdpv4mP9DdZwCbRzuRQ9n5vGZkd7qZCWMwx8R3+uQ6zgjFtmxUSedKJG\n" +
//                "/pq3Rjkf9Xl8L32VjUJM9kMxk+/g127bNJZpjrpBJqlV0lyRbm5KSYpfSdLwg9Hn\n" +
//                "aKNuztkCgYEA73zTmbnrRSN6svjTnR3u7eE5t7hm+hObFfBnWDyi3/VYpURtrhKg\n" +
//                "R5QDnlda4iVdWo2LUfvOvo+jXcd0NRD1h2T2uBsPXy4E+ChZADgFLcaYWlrJVYYw\n" +
//                "1uHuBocWAZx1zpQzjFMCt8t2jOE2YEJZJXX+fRpcP4gf+E+xD+EZxX8CgYEAziHb\n" +
//                "X2PZ0cqgA2dwrSjEuJ5+XaAtuToF/cew6QOYe5PJ6n6+Q8dq2eW8w3YadXvmIhCF\n" +
//                "/c+e7iC2YRuaJGrG6bMS/13i0/Z+VXBfxTV0JPtnSWq9uolfzd49WDPg+EcVQpKM\n" +
//                "BrHAQdbol+6kCg+pvtNK15UWpYAhyeTELMNfur8CgYEAhXXAzghn7i2pcRdthj9q\n" +
//                "KTK8YX/oEzDd2koQrYGNGtW1QtRxcvJ6U6lOouz3ftNnxNDgdR2ox1VwqxA92FzN\n" +
//                "F1jSjSK3XElfB5QklRSi/jGQMboqPPj9OqLJbOXXA6rXk/nPCEIyX46JUFUpYldX\n" +
//                "KqMo4TrRca5Acrama7z8Ca0CgYASSJSBuISYhCV/R8yJv2T7jytcOJn1pPzlDrJV\n" +
//                "aLk8tNYjE4zizCxhGWyN1crxAsVd3iNUaPcK3iHvKRiaBFKSZgzYU8aL0IBSKb6E\n" +
//                "6oHbyeTWcT5U7lxuETlVunxI6V0sY31CFsAb1ukYmNU6AzumLm2kA5hXo67bjowM\n" +
//                "AGRcVwKBgQCby3FhBRnlWpm0gLOHHirWPJyr18WCUxRXLZbqdylVTuD8b7WRdLdz\n" +
//                "TeOCIlJ8Pu7PWwj8Q4LvPI+nzO+BMEqH0J+apvkbicRL0xfE+VJDMjKyqlQOzr2T\n" +
//                "8XMfTdciv0z6w1QR/+uvlcZ5ANuA9AnVyV4hBJo7BIz8x47Htj9kkQ=="


        val AES_IV = "2175362433533828"
    }
}