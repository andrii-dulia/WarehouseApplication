package model;

import javax.persistence.*;

/**
 * ... comment class...
 *
 * @author ptrkukla148@gmail.com
 * @since 05.09.2020
 */

@Entity(name="addresses")
public class Address {

        @Id
        @Column(name="address_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long addressId;

        @Column(name="country")
        private String country;

        @Column(name="city")
        private String city;

        @Column(name="post_code")
        private String post_code;

        @Column(name="street")
        private String street;

        @Column(name="number")
        private Long number;

        @OneToOne
        @JoinColumn(name = "client_id")
        private Client client;


        public long getAddressId(Address address) {
                return addressId;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getPost_code() {
                return post_code;
        }

        public void setPost_code(String post_code) {
                this.post_code = post_code;
        }

        public String getStreet() {
                return street;
        }

        public void setStreet(String street) {
                this.street = street;
        }

        public Long getNumber() {
                return number;
        }

        public void setNumber(Long number) {
                this.number = number;
        }

        public Client getClient() {
                return client;
        }

        public void setClient(Client client) {
                this.client = client;
        }
}
