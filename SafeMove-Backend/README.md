# SafeMove Backend (Java Web)

Backend được xây dựng bằng **Spring Boot + Spring Data JPA** theo schema `SafeMove` bạn cung cấp.

## 1) Chạy dự án
```bash
cd SafeMove-Backend
mvn spring-boot:run
```

## 2) Cấu hình database SQL Server
Cập nhật file `src/main/resources/application.properties`:
- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

> Mặc định backend dùng `ddl-auto=validate` để kiểm tra schema có đúng với DB thực tế.

## 3) API đã có
- `GET/POST /api/accounts`
- `GET /api/master/vehicle-types`
- `GET /api/master/services`
- `GET/POST /api/survey-requests`
- `GET/POST /api/contracts`
- `GET/POST /api/payments`

## 4) Luồng tạo Survey Request có tính giá
`POST /api/survey-requests` nhận payload:
```json
{
  "customerId": 1,
  "serviceId": 1,
  "pickupAddress": "A",
  "destinationAddress": "B",
  "startDate": "2026-03-01",
  "numStaff": 3,
  "estimatedDistanceKm": 12
}
```

Backend sẽ:
1. Lấy `base_price` từ bảng `Service`.
2. Tìm khung giá phù hợp trong `Price_Table` theo `estimatedDistanceKm`.
3. Tính `estimated_price = base_price + price_per_km * distance`.
4. Lưu `Survey_Request` với trạng thái `PENDING`.
