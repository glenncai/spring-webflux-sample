CREATE TABLE IF NOT EXISTS users
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    balance BIGINT       NOT NULL
);

CREATE TABLE IF NOT EXISTS user_transaction
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT    NOT NULL,
    amount           BIGINT    NOT NULL,
    transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO users (name, balance)
VALUES ('user1', 1000),
       ('user2', 1200),
       ('user3', 2000),
       ('user4', 3500),
       ('user5', 500),
       ('user6', 800),
       ('user7', 200),
       ('user8', 300),
       ('user9', 3740),
       ('user10', 6009);

