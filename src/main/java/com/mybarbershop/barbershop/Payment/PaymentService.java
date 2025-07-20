package com.mybarbershop.barbershop.Payment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Value("${payment.api.key}")
    private String apiKey;

    @Value("${payment.category.code}")
    private String categoryCode;

    @Value("${payment.api.url}")
    private String apiUrl;

    @Value("${payment.return.url}")
    private String returnUrl;

    @Value("${payment.callback.url}")
    private String callbackUrl = "https://0a4f0b505476.ngrok-free.app";

    public String createBill(Payment payment) {

        String url = apiUrl + "/index.php/api/createBill";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userSecretKey", apiKey);
        params.add("categoryCode", categoryCode);
        params.add("billName", payment.getBillName());
        params.add("billDescription", payment.getBillDescription());
        params.add("billPriceSetting", String.valueOf(payment.getBillPriceSetting()));
        params.add("billPayorInfo", String.valueOf(payment.getBillPayorInfo()));
        params.add("billAmount", String.valueOf((int) (payment.getAmount() * 100))); // RM to sen
        params.add("billReturnUrl", returnUrl);
        params.add("billCallbackUrl", callbackUrl);
        params.add("billExternalReferenceNo", payment.getBillExternalReferenceNo());
        params.add("billTo", payment.getBillTo());
        params.add("billEmail", payment.getBillEmail());
        params.add("billPhone", payment.getBillPhone());
        params.add("billPaymentChannel", String.valueOf(payment.getBillPaymentChannel()));
        params.add("billChargeToCustomer", String.valueOf(payment.getBillChargeToCustomer()));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // Parse JSON response using Jackson
        ObjectMapper mapper = new ObjectMapper();
        JsonNode arr;
        try {
            arr = mapper.readTree(response.getBody());
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new RuntimeException("Failed to parse JSON response", e);
        }
        String billCode = arr.get(0).get("BillCode").asText();

        // Return full payment link
        return apiUrl + "/" + billCode;
    }


}
