package model;

import javax.persistence.*;

/**
 * ... comment class...
 *
 * @author ptrkukla148@gmail.com
 * @since 05.09.2020
 */

@Entity
@Table(name="addresses")
public class Address {

        @Id
        @Column(name="address_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long addressId;

        @Column(name="country")
        private String country;

        @Column(name="city")
        private String city;

        @Column(name="post_code")
        private String post_code;

        @Column(name="street_and_number")
        private String street_and_number;

        @OneToOne
        @JoinColumn(name = "client_id")
        private Client client;


        public Address(String country, String city, String post_code, String street_and_number) {
                this.country = country;
                this.city = city;
                this.post_code = post_code;
                this.street_and_number = street_and_number;
        }

        public void setAddressId(long addressId) {
                this.addressId = addressId;
        }

        public void setClient(Client client) {
                this.client = client;
        }

        public long getAddressId() {
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

        public String getStreet_and_number() {
                return street_and_number;
        }

        public void setStreet_and_number(String street_and_number) {
                this.street_and_number = street_and_number;
        }

        public Client getClient() {
                return client;
        }

        @Override
        public String toString() {
                return "Address{" +
                        "addressId=" + addressId +
                        ", country='" + country + '\'' +
                        ", city='" + city + '\'' +
                        ", post_code='" + post_code + '\'' +
                        ", street_and_number='" + street_and_number + '\'' +
                        '}';
        }
}
