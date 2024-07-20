-- Inserting users into the users table
INSERT INTO users (username, password, email, role, blocked)
VALUES
    ('user1', '$2a$10$TRU9QyH5ug1fv30fK6yJO.4w.3F/gjX5bU34WkKg5P6s8PT7bPbS.', 'user1@example.com', 'USER', false),
    ('admin1', '$2a$10$H7TH83BwZi5vPSJVXO3yGep5Mb0AZm3e9ItH2VfPnlk2MJ4sAu9O2', 'admin1@example.com', 'ADMIN', false),
    ('doctor1', '$2a$10$PXUCMlL.z8n8b8VJx.Ug8OqZkA3fUwy1xmcyOrOWjDbUzFl.5pslK', 'doctor1@example.com', 'DOCTOR', false),
    -- Add more users here as needed
    ('user2', '$2a$10$zQxIY1pT9vYmN7LQihdy2u4isJx6D4D30f0F/gW8R6aIy6ENaHC8K', 'user2@example.com', 'USER', false),
    ('admin2', '$2a$10$7C2LwTGHq8mrgDKz86v8gOx44wq5K3s.WpZ8w.vUfDptpm07hE7za', 'admin2@example.com', 'ADMIN', false),
    -- Add more users here as needed
    ('doctor2', '$2a$10$07kFE78Mj/JGj8aB5Aibw.g3V18ulJWu3NJL5uf0I/4Rq8Ls.3U/S', 'doctor2@example.com', 'DOCTOR', false),
    ('user3', '$2a$10$U0HdH3geLoNbzYqE4kFMBe7r7Ao5G3SXPYH2Bc58b9Sg4.dLwomlW', 'user3@example.com', 'USER', false),
    -- Add more users here as needed
    ('admin3', '$2a$10$zFUT7F6M5BbJTo8zZl.cj.7dkjKLsDPOlCul6WUJUNu/ERHxptI5a', 'admin3@example.com', 'ADMIN', false),
    ('doctor3', '$2a$10$X8kPVGaW6PCzgqEEJdJ8I.FGcgSut5jqudZwS11RMNqzKXeB1I1ua', 'doctor3@example.com', 'DOCTOR', false),
    ('user4', '$2a$10$GkM3ZrZBl6b8Q1hPAn5Aju2XPCQJDTJiUQW7sG0g1VZRMlXNEFtD6', 'user4@example.com', 'USER', false),
    ('admin4', '$2a$10$uevU5MmGfJabHo8tXvKmi.6O1BwB.FMcZaJd7hfnbK1.HIqRcPNuq', 'admin4@example.com', 'ADMIN', false),
    ('doctor4', '$2a$10$7IeIc48e.3L/2qLkMfAaFeEL8kZ.EKqRcTYFfIDedSj6ILibHxO1C', 'doctor4@example.com', 'DOCTOR', false),
    ('user5', '$2a$10$exVpMRZpv6NyEaVbPNz.wuTdbZd7qkDYzU5FFzHnCfCqmvKLHsYvW', 'user5@example.com', 'USER', false),
    ('admin5', '$2a$10$tFgMo0xyx9jDtW2pgN1F2OfVdK85r54QSkni6FTGCDZUsn7ABGzqu', 'admin5@example.com', 'ADMIN', false),
    ('doctor5', '$2a$10$7crU1AR98rr2Mun6qjPOteDPfE8QIpe0E2zv12bCEZQx0yob9ITZy', 'doctor5@example.com', 'DOCTOR', false),
    ('user6', '$2a$10$vsHxw6gD72xN79vKQ8C0n.Wzh0.XBu7bV3FpKbu8gBtTnOFVlFp7G', 'user6@example.com', 'USER', false),
    ('admin6', '$2a$10$lZSK1YVdf3lp5wCw82FCJOwFwqHw5pTb2jJmO9/VEd3j3xx8qMLz6', 'admin6@example.com', 'ADMIN', false),
    ('doctor6', '$2a$10$gGN0X4qD.4nMPfh6YlRROOz6ah2qAcYBNGqYpRpfM5P/Sq0NpBzS.', 'doctor6@example.com', 'DOCTOR', false),
    ('user7', '$2a$10$Rkt9t8X7KMeAWeXbAF3TnuqEqw/xSWjLqO.4R5wTCC2U4I4Qbcw9e', 'user7@example.com', 'USER', false),
    ('admin7', '$2a$10$zNLdXqJyKBg4PUxy6z57l.NLmE.tG4kQ9rN5N4y1.0hXOZYJ7UIO6', 'admin7@example.com', 'ADMIN', false),
    ('doctor7', '$2a$10$JyWvqlp.0j6NjE30sSddXOMaOo6mkeUBDXA6Wm.dYNG9.VHrK8C7S', 'doctor7@example.com', 'DOCTOR', false),
    ('user8', '$2a$10$05jN6bP/VQPMKAb8hOS2DOwot9S6QdO75Dp0VvC3LrXa50P75ARuy', 'user8@example.com', 'USER', false),
    ('admin8', '$2a$10$W.TZaQyJxj7QVR4Wus.TouyT8r0PizCEONpLyOxjwVND72rqgFjZS', 'admin8@example.com', 'ADMIN', false),
    ('doctor8', '$2a$10$3AclnokgsD3USoQW8lnz6..1.yYYOe4hwGxLmShrNZJy/Y4sJDLtG', 'doctor8@example.com', 'DOCTOR', false),
    ('user9', '$2a$10$ddBRoOF7JkN90PqD2oKqQOXtFG.Szg7FNQy/yIw1Fm5GebV5t4oKu', 'user9@example.com', 'USER', false),
    ('admin9', '$2a$10$ndg0BfQV/q2K/Oc8sGKlIe4kzCmXK7Sip1G9FVbiBDFtWrglVcq56', 'admin9@example.com', 'ADMIN', false),
    ('doctor9', '$2a$10$0dQ19H8E4m8F.wDmF0s4v.u6KzP0q3BNn.Wpl3bkh6y1YNoqckXtW', 'doctor9@example.com', 'DOCTOR', false),
    ('user10', '$2a$10$SZUER6i.H06mF3S4sXl0hOJapqSx28bC5Fyq1IY6FqI2CEY/OmCaa', 'user10@example.com', 'USER', false),
    ('admin10', '$2a$10$E4Pm71zumWdqylsD0T0h7uFQFFBlCp0Y9jEYprufwQFV8le5CZkWe', 'admin10@example.com', 'ADMIN', false),
    ('doctor10', '$2a$10$pg4z0TqMvLkE0IZ5Eq7A7.9fj0LzRVE2e2b7r4cZ1KlfD4.Mt3JZ2', 'doctor10@example.com', 'DOCTOR', false),
    ('user11', '$2a$10$OIXr2esIsQgY.Ir2tY0cMuK9M7a5D/GPA03O/xJ6ICe/Y8V.zMR7q', 'user11@example.com', 'USER', false),
    ('admin11', '$2a$10$0V3o6NH6evb2tPc/4B8Xj.J8PJFE4MnszQ5LmPc6D.x8Z4m2vE0/6', 'admin11@example.com', 'ADMIN', false),
    ('doctor11', '$2a$10$36kwh3L1exAC3Pv0jcvz8u6L0ISs3CzxUs1Uf.4PuaKwFjQ.qFf0e', 'doctor11@example.com', 'DOCTOR', false),
    ('user12', '$2a$10$jshk5Alk0k6frt3ccuzH0eDYZ60VUolndY61d5wyExeDjFSE9gdWe', 'user12@example.com', 'USER', false),
    ('admin12', '$2a$10$PLye9bPTDlBP7PE4W6Jgq.WKRnZ8c7IMN.3PNC9Kr1i1KBm9DUcZK', 'admin12@example.com', 'ADMIN', false),
    ('doctor12', '$2a$10$Dz10DhjN4pIrLbZ50A7tT.KS/nb7g29JRAptSjuQXQ.2fbKu0J7HG', 'doctor12@example.com', 'DOCTOR', false),
    ('user13', '$2a$10$U5COKI9Xz0B0NlJ73ZSvzeS4/78Ji3Ynif1.IIv6z0EoFQlaoyT6W', 'user13@example.com', 'USER', false),
    ('admin13', '$2a$10$AF9vJCBPCh72qA4Z0Tg8Xu8GZzAe.xcbO/8.d1rX5V3jxdle4QFXO', 'admin13@example.com', 'ADMIN', false),
    ('doctor13', '$2a$10$45PH9X3jXfcD3fMkpr5Vt.pLMXNhdUZ5kZ.2zXo4kR4kLBRXlzszW', 'doctor13@example.com', 'DOCTOR', false),
    ('user14', '$2a$10$vM84P85xt1yx2XFTT2nU6ODXTFos4mOQSuY3PdV/cL6gOFxLlL3mG', 'user14@example.com', 'USER', false),
    ('admin14', '$2a$10$H/ISqKAmGdNf4imSx7BVReQF.VyRQxFWhIPr57.0FvUjZG6xeq7/i', 'admin14@example.com', 'ADMIN', false),
    ('doctor14', '$2a$10$8s7lEhDzKWbC4fF2rV/.U.E4k4HJ2l6Q7MOZFlD.D72Ji0Z4tC4hG', 'doctor14@example.com', 'DOCTOR', false),
    ('user15', '$2a$10$Z7PLJ1VOcZVgE1GVGGT2eO46sWdNcRq2IgglLTF8C8HCt83DZzY2y', 'user15@example.com', 'USER', false),
    ('admin15', '$2a$10$5Qm6lIY0ZC5KFSV8OZzMseSXqZQ5IQ2kIuP19bA9yBCh.Z2NC1UcW', 'admin15@example.com', 'ADMIN', false),
    ('doctor15', '$2a$10$8o.kKs0eX6Yjwll9G9aJdO9MfLrBQVJ6vN5/9m4nl67B4CMBqQ01m', 'doctor15@example.com', 'DOCTOR', false),
    ('user16', '$2a$10$B3MaC4wYk/w4foZ5.wZb4eExQ6n.mPUy2F2pRy0nOyDMlG2aRv2bO', 'user16@example.com', 'USER', false),
    ('admin16', '$2a$10$XvLcR2r/axaTFxvMl4sufu.3T8D/kjS1c5Ktq0JOMNTPUOJ.f5NBy', 'admin16@example.com', 'ADMIN', false),
    ('doctor16', '$2a$10$iMg7FZdIKfYs5Y4DFC61XO3M2Qk2m41e.qD9XTS2U2PJEFfD0UHry', 'doctor16@example.com', 'DOCTOR', false),
    ('user17', '$2a$10$ZoDrh1vMWEr7h/KgM6f8Zu67IlyrTW7NCS1awYUMKZGvO7NZvD20W', 'user17@example.com', 'USER', false),
    ('admin17', '$2a$10$ERgZHC3l6JWiRVO7PR6ayu8Fv/JF9eAH5.Ho5F1lDFiDJzaXhTGZC', 'admin17@example.com', 'ADMIN', false),
    ('doctor17', '$2a$10$Z5g1d2p3tKtLZ3z4w7vNHeOi4ioF5m4h72n7TGO4M5Mq04K2Pp6Pa', 'doctor17@example.com', 'DOCTOR', false),
    ('user18', '$2a$10$gk7FwvrDms5A1/4Zw8sjXeyCLLZfEoTgsFV4UYQuC2i19R8b2cJG2', 'user18@example.com', 'USER', false),
    ('admin18', '$2a$10$m1B9fnwujG.LW.YleRfmdeW8s8eeXuQayEkQ2I5thpCzSA5yrCcyi', 'admin18@example.com', 'ADMIN', false),
    ('doctor18', '$2a$10$MMt2HnO2Xtg.W7HUt2c5Fe1vR8a7/7iVepFf1BtY1eUdZsWlgGVXy', 'doctor18@example.com', 'DOCTOR', false),
    ('user19', '$2a$10$OhDQuETelX.WbOeVT1.A8Owde1Vx7vWlBjVnL9sjitv5A33XqQqZS', 'user19@example.com', 'USER', false),
    ('admin19', '$2a$10$vc4D..X5Ggct.hI7y5Pjs.nZ1EXJXt3eKrcG3n.Dw4gY3Aje6dZlK', 'admin19@example.com', 'ADMIN', false),
    ('doctor19', '$2a$10$DNFh2IW.FmG1YulD3DBJzuNVKpmRnMPGeFow1Zr91aNRXGL8lCLtO', 'doctor19@example.com', 'DOCTOR', false),
    ('user20', '$2a$10$kU1D8HjeS/4k7RXv08y7seL1f4Wp5EnLZ8C.dTl5j6wmXzCfCrr7G', 'user20@example.com', 'USER', false),
    ('admin20', '$2a$10$ZMRrH1Mw3noe5NoE.7e.DOhGT0Mf9gyGkHEU1nbK7FhRJZaWdJ5cK', 'admin20@example.com', 'ADMIN', false),
    ('doctor20', '$2a$10$5S8N/Crfe4Ob67zdeS4djOfFZc9mIn1RXJmEH1B5X7PpsFv6bl6DW', 'doctor20@example.com', 'DOCTOR', false),
    ('user21', '$2a$10$7NnbWXXR4wP9m5VH74ifg.p80SkhBkDkA.0o75qavWEDbXm6f0KZS', 'user21@example.com', 'USER', false),
    ('admin21', '$2a$10$Ah9Te5p0S8DW7U5Q6mK8lOc9nQnPSf5SDdROIsfIFrUu7sNHQ.E7m', 'admin21@example.com', 'ADMIN', false),
    ('doctor21', '$2a$10$1tky2xXH4/hVxzFRl90ZueZhRHPz5g8z0EKzSKbYRmtE3tPfr3b96', 'doctor21@example.com', 'DOCTOR', false),
    ('user22', '$2a$10$VBUDtiDsm29Y6dRZ18B9J.TZuBlHR8gXC2FS5q3yyJi7ieY.5.Qw2', 'user22@example.com', 'USER', false),
    ('admin22', '$2a$10$8Sle//46U9fRc8c0RVr5s.1JdHIFr8S9DlN4O.FgNsoYdf6upw0F6', 'admin22@example.com', 'ADMIN', false),
    ('doctor22', '$2a$10$gBzHbNi.Mz5/3HjlmIw3KucD02XiCbyWCRvs6yeC5TkOGJp5ImS4y', 'doctor22@example.com', 'DOCTOR', false),
    ('user23', '$2a$10$6J85HFnzxYwrp/MoSRP2feIb7cX5W2ZZvMlJfUtJl1Mg9PKEy.yEu', 'user23@example.com', 'USER', false),
    ('admin23', '$2a$10$y5uCDuA1l2quq1FO7usxhu8V6TEZtjg.n8ekTkiOu7DlLHkWzOtT6', 'admin23@example.com', 'ADMIN', false),
    ('doctor23', '$2a$10$CmzR2MqX4NlD3LcUoGomROK5N8apfI0zYmPwNkK5Mc.pAeGt7nZHG', 'doctor23@example.com', 'DOCTOR', false),
    ('user24', '$2a$10$5BfWIRLxEMZ8An6Jp5p.2eZtOC30Wp4RJp2B8B9NHkfm0Fm9etn5K', 'user24@example.com', 'USER', false),
    ('admin24', '$2a$10$5yFio0N5LxZSO6i2Bk3ES.qubYBzq1xvON7/R5umLqNN2BlF1aL9q', 'admin24@example.com', 'ADMIN', false),
    ('doctor24', '$2a$10$YuBw0HU/fzG7v38pDvEKb.wy7x3FgHvOVQ0iZ8TECdf8JzC0Eie8y', 'doctor24@example.com', 'DOCTOR', false),
    ('user25', '$2a$10$6LbHzZy3XtJwQGALt5h5luquSHcY5HOf4Oy/RcEKsOwS5PPG8W7XG', 'user25@example.com', 'USER', false),
    ('admin25', '$2a$10$iwB5itJ01NzYlPJFMRd0lOZpmFWf7P9re5v/m1vO2iJNJmCmWu4K6', 'admin25@example.com', 'ADMIN', false),
    ('doctor25', '$2a$10$yX4IAZBHR58eL30qYfNq7uQWq4tibDc35F0APBLQpmOBbHbQwTm2i', 'doctor25@example.com', 'DOCTOR', false),
    ('user26', '$2a$10$fNLFJ6VVhKb5ExkTTo.JDusE0vcTL.Ia8vF/yIQmIjok2aVtH5nyq', 'user26@example.com', 'USER', false),
    ('admin26', '$2a$10$X1KvR4b7P4j7f1e7cF6Jkuo36iiK2.RB6z8bAqFJ8OD5z5crFm6x6', 'admin26@example.com', 'ADMIN', false),
    ('doctor26', '$2a$10$T1m5ICpWZ/zZCq7pNJm7Ju7bKbCQ9g4pm8gFeAfBQpR.O3IXiF5Ai', 'doctor26@example.com', 'DOCTOR', false),
    ('user27', '$2a$10$Uu1qboQxSPVf8IY5Bo/fYe2mKuSkOi0s9bKlPBUNtGj/qGsPnCTku', 'user27@example.com', 'USER', false),
    ('admin27', '$2a$10$ee6PeQwak9d2sufRZiAWeu9zLPxGqJzslNlyADT5B74eQYcyIa8Ue', 'admin27@example.com', 'ADMIN', false),
    ('doctor27', '$2a$10$WrltWp4xFAsyye2A32ZwJOMtPzNZvPPexV2fGAHHPgVX4YvllTJmC', 'doctor27@example.com', 'DOCTOR', false),
    ('user28', '$2a$10$Kb3F5d5XK8oA/6rj2f4r6eAlQ0C5aQCR60xT9mlW9Lb9WITvFFRi2', 'user28@example.com', 'USER', false),
    ('admin28', '$2a$10$wajX8N8g14nv5EM.9opOnus2H5eLcV/4UPdF8PqWcQKvFSiAK80Ge', 'admin28@example.com', 'ADMIN', false),
    ('admin', '$2a$10$wajX8N8g14nv5EM.9opOnus2H5eLcV/4UPdF8PqWcQKvFSiAK80Ge', 'vadimKh17@gmail.com', 'ADMIN', false);

INSERT INTO doctor (name, specialization, working_hours)
VALUES
    ('Доктор Иванов', 'Терапевт', 'Понедельник-пятница, 9:00-18:00'),
    ('Доктор Петров', 'Хирург', 'Понедельник-среда, 10:00-17:00'),
    ('Доктор Сидорова', 'Окулист', 'Вторник-четверг, 8:00-15:00'),
    ('Доктор Смирнов', 'Кардиолог', 'Понедельник, среда, пятница, 12:00-20:00'),
    ('Доктор Козлова', 'Гинеколог', 'Вторник, четверг, суббота, 10:00-18:00'),
    ('Доктор Михайлов', 'Оториноларинголог', 'Понедельник-пятница, 8:00-17:00'),
    ('Доктор Васильев', 'Эндокринолог', 'Понедельник-среда, 9:00-16:00'),
    ('Доктор Попов', 'Педиатр', 'Вторник-четверг, 10:00-19:00'),
    ('Доктор Соколов', 'Невролог', 'Понедельник, среда, пятница, 11:00-18:00'),
    ('Доктор Лебедев', 'Уролог', 'Вторник, четверг, суббота, 9:00-17:00'),
    ('Доктор Кузнецова', 'Дерматолог', 'Понедельник-пятница, 8:30-16:30'),
    ('Доктор Ильина', 'Офтальмолог', 'Понедельник-среда, 10:00-18:00'),
    ('Доктор Григорьев', 'Эндоскопист', 'Вторник-четверг, 11:00-19:00'),
    ('Доктор Куликов', 'Эндокринолог', 'Понедельник, среда, пятница, 9:00-17:00'),
    ('Доктор Орлова', 'Стоматолог', 'Понедельник-пятница, 8:00-15:00'),
    ('Доктор Федоров', 'Хирург', 'Понедельник-четверг, 12:00-20:00'),
    ('Доктор Алексеева', 'Гастроэнтеролог', 'Вторник-пятница, 9:00-18:00'),
    ('Доктор Дмитриев', 'Психиатр', 'Понедельник-среда, 10:00-17:00'),
    ('Доктор Николаева', 'Ревматолог', 'Вторник-четверг, 11:00-19:00'),
    ('Доктор Павлов', 'Кардиолог', 'Понедельник-пятница, 8:30-16:30'),
    ('Доктор Маркова', 'Оториноларинголог', 'Понедельник-среда, 9:00-17:00'),
    ('Доктор Богданова', 'Пульмонолог', 'Вторник, четверг, суббота, 10:00-18:00'),
    ('Доктор Киселева', 'Эндокринолог', 'Понедельник-пятница, 8:00-15:00'),
    ('Доктор Тимофеева', 'Офтальмолог', 'Понедельник-четверг, 12:00-20:00'),
    ('Доктор Воробьев', 'Уролог', 'Вторник-пятница, 9:00-18:00'),
    ('Доктор Кудряшова', 'Дерматолог', 'Понедельник-среда, 10:00-17:00'),
    ('Доктор Жуков', 'Ортопед', 'Понедельник-пятница, 8:30-16:30'),
    ('Доктор Сергеева', 'Стоматолог', 'Вторник-четверг, 11:00-19:00'),
    ('Доктор Романова', 'Хирург', 'Понедельник-среда, 9:00-17:00'),
    ('Доктор Кондратьева', 'Гинеколог', 'Вторник-пятница, 10:00-18:00');

INSERT INTO patients (user_id, first_name, last_name, date_of_birth, gender, address, phone_number, weight, height, allergies, emergency_contact)
VALUES
    (1, 'John', 'Doe', '1990-05-15', 'Male', '123 Main St, Anytown', '123-456-7890', 70.5, 180.0, 'Pollen', 'Jane Doe'),
    (2, 'Jane', 'Smith', '1985-08-20', 'Female', '456 Elm St, Othertown', '234-567-8901', 65.2, 165.0, 'Penicillin', 'John Smith'),
    -- Add more patients here as needed
    (3, 'Michael', 'Johnson', '1982-04-10', 'Male', '789 Oak Ave, Anycity', '345-678-9012', 80.0, 175.0, 'Shellfish', 'Sarah Johnson'),
    (4, 'Emily', 'Brown', '1995-12-01', 'Female', '567 Pine Rd, Sometown', '456-789-0123', 55.0, 160.0, 'None', 'David Brown'),
    -- Add more patients here as needed
    (5, 'Daniel', 'Martinez', '1988-09-25', 'Male', '890 Cedar Blvd, Otherville', '567-890-1234', 75.3, 185.0, 'Dust', 'Maria Martinez'),
    (6, 'Sophia', 'Garcia', '1993-07-18', 'Female', '678 Maple Ln, Anywhere', '678-901-2345', 60.5, 170.0, 'Pollen', 'James Garcia'),
    -- Add more patients here as needed
    (7, 'Ethan', 'Wilson', '1991-02-28', 'Male', '901 Birch Dr, Anycity', '789-012-3456', 85.0, 180.0, 'Peanuts', 'Emma Wilson'),
    (8, 'Olivia', 'Lopez', '1987-06-05', 'Female', '789 Willow Ave, Othertown', '890-123-4567', 58.9, 162.0, 'Lactose', 'Noah Lopez'),

    (9, 'Alexander', 'Taylor', '1994-11-14', 'Male', '234 Spruce St, Sometown', '901-234-5678', 70.2, 175.0, 'Eggs', 'Ava Taylor'),
    (10, 'Ava', 'Hernandez', '1989-03-30', 'Female', '678 Pinecone Rd, Otherville', '012-345-6789', 63.7, 168.0, 'Soy', 'Liam Hernandez'),

    (11, 'Noah', 'Lee', '1983-08-12', 'Male', '345 Maple Dr, Anytown', '123-456-7890', 76.5, 182.0, 'None', 'Isabella Lee'),
    (12, 'Isabella', 'Gonzalez', '1986-05-08', 'Female', '890 Oak St, Otherville', '234-567-8901', 61.8, 166.0, 'Pollen', 'Elijah Gonzalez'),

    (13, 'James', 'Clark', '1992-10-20', 'Male', '567 Birch Ave, Anycity', '345-678-9012', 79.0, 178.0, 'Dairy', 'Charlotte Clark'),
    (14, 'Charlotte', 'Walker', '1997-01-05', 'Female', '678 Elm Ln, Sometown', '456-789-0123', 57.2, 159.0, 'Pollen', 'Mason Walker'),
    -- Add more patients here as needed
    (15, 'Benjamin', 'Perez', '1984-07-23', 'Male', '123 Cedar Rd, Anywhere', '567-890-1234', 72.4, 183.0, 'Pollen', 'Amelia Perez'),
    (16, 'Amelia', 'Roberts', '1990-04-03', 'Female', '456 Pine Blvd, Othertown', '678-901-2345', 62.3, 167.0, 'Pollen', 'Jacob Roberts'),
    -- Add more patients here as needed
    (17, 'Daniel', 'Cook', '1993-09-18', 'Male', '789 Maple Dr, Anycity', '789-012-3456', 83.5, 181.0, 'Penicillin', 'Olivia Cook'),
    (18, 'Mia', 'Rossi', '1988-06-29', 'Female', '890 Oak Ave, Sometown', '890-123-4567', 59.1, 163.0, 'None', 'William Rossi'),
    -- Add more patients here as needed
    (19, 'William', 'Evans', '1985-02-09', 'Male', '234 Pine Rd, Anytown', '901-234-5678', 68.7, 176.0, 'Shellfish', 'Sophia Evans'),
    (20, 'Victoria', 'Martinez', '1996-11-28', 'Female', '567 Elm St, Otherville', '012-345-6789', 54.8, 158.0, 'None', 'Alexander Martinez'),
    -- Add more patients here as needed
    (21, 'Jacob', 'Hernandez', '1989-04-15', 'Male', '678 Birch Blvd, Anycity', '123-456-7890', 77.2, 184.0, 'Pollen', 'Emily Hernandez'),
    (22, 'Sophia', 'Lopez', '1992-12-17', 'Female', '789 Cedar Ave, Sometown', '234-567-8901', 61.4, 165.0, 'Peanuts', 'Daniel Lopez'),
    -- Add more patients here as needed
    (23, 'Michael', 'Gonzalez', '1994-08-02', 'Male', '901 Oak Ln, Anytown', '345-678-9012', 81.0, 179.0, 'Pollen', 'Mia Gonzalez'),
    (24, 'Abigail', 'Young', '1986-03-10', 'Female', '123 Birch Dr, Othertown', '456-789-0123', 56.5, 161.0, 'None', 'Noah Young'),
    -- Add more patients here as needed
    (25, 'Alexander', 'Wilson', '1991-10-29', 'Male', '456 Pinecone Rd, Anycity', '567-890-1234', 74.8, 177.0, 'Lactose', 'Emma Wilson'),
    (26, 'Emily', 'Moore', '1987-05-07', 'Female', '678 Spruce St, Sometown', '678-901-2345', 59.8, 164.0, 'Pollen', 'Oliver Moore'),
    -- Add more patients here as needed
    (27, 'James', 'Taylor', '1995-01-14', 'Male', '789 Maple Dr, Anytown', '789-012-3456', 78.3, 180.0, 'Eggs', 'Ava Taylor'),
    (28, 'Olivia', 'Brown', '1990-06-23', 'Female', '890 Elm Ave, Otherville', '890-123-4567', 60.2, 166.0, 'Soy', 'Logan Brown'),
    -- Add more patients here as needed
    (29, 'Benjamin', 'Martinez', '1983-11-18', 'Male', '234 Oak St, Anycity', '901-234-5678', 71.6, 178.0, 'Dust', 'Sofia Martinez'),
    (30, 'Emma', 'Garcia', '1988-04-05', 'Female', '567 Cedar Rd, Sometown', '012-345-6789', 64.0, 169.0, 'Pollen', 'Lucas Garcia'),
    -- Add more patients here as needed
    (31, 'Ethan', 'Rodriguez', '1992-09-20', 'Male', '678 Birch Ave, Anytown', '123-456-7890', 82.1, 182.0, 'Dairy', 'Amelia Rodriguez'),
    (32, 'Sophia', 'Hernandez', '1997-02-05', 'Female', '789 Elm Ln, Otherville', '234-567-8901', 58.7, 162.0, 'Pollen', 'Elijah Hernandez'),
    -- Add more patients here as needed
    (33, 'Daniel', 'Lopez', '1984-07-23', 'Male', '901 Pine Dr, Anycity', '345-678-9012', 73.2, 179.0, 'Dairy', 'Ava Lopez'),
    (34, 'Ava', 'Gonzalez', '1990-04-03', 'Female', '123 Cedar Ave, Anytown', '456-789-0123', 61.5, 165.0, 'None', 'Elijah Gonzalez'),
    -- Add more patients here as needed
    (35, 'Noah', 'Young', '1993-09-18', 'Male', '456 Oak Rd, Othertown', '567-890-1234', 79.5, 183.0, 'Pollen', 'Mia Young'),
    (36, 'Isabella', 'Moore', '1988-06-29', 'Female', '678 Elm Dr, Anycity', '678-901-2345', 55.9, 160.0, 'Penicillin', 'Mason Moore'),
    -- Add more patients here as needed
    (37, 'James', 'Martinez', '1991-02-09', 'Male', '789 Pine St, Anytown', '789-012-3456', 84.3, 181.0, 'None', 'Charlotte Martinez'),
    (38, 'Charlotte', 'King', '1996-11-28', 'Female', '890 Birch Rd, Otherville', '890-123-4567', 60.8, 167.0, 'Peanuts', 'William King'),
    -- Add more patients here as needed
    (39, 'Benjamin', 'Rivera', '1989-04-15', 'Male', '234 Maple Ave, Anycity', '901-234-5678', 69.2, 176.0, 'Lactose', 'Sophia Rivera'),
    (40, 'Mia', 'Scott', '1992-12-17', 'Female', '567 Oak Blvd, Othertown', '012-345-6789', 57.4, 163.0, 'Pollen', 'Lucas Scott');
-- Пример 1
INSERT INTO contact (name, email, massage) VALUES ('John Doe', 'john.doe@example.com', 'This is a test message.');

-- Пример 2
INSERT INTO contact (name, email, massage) VALUES ('Jane Smith', 'jane.smith@example.com', 'Another message for testing.');

-- Пример 3
INSERT INTO contact (name, email, massage) VALUES ('Alice Johnson', 'alice.johnson@example.com', 'Feedback on the service provided.');

-- Пример 4
INSERT INTO contact (name, email, massage) VALUES ('Bob Brown', 'bob.brown@example.com', 'Query regarding appointment scheduling.');

-- Пример 5
INSERT INTO contact (name, email, massage) VALUES ('Emily Davis', 'emily.davis@example.com', 'Issue with the online payment system.');

-- Пример 6
INSERT INTO contact (name, email, massage) VALUES ('Michael Wilson', 'michael.wilson@example.com', 'Suggestion for improving waiting times.');

-- Пример 7
INSERT INTO contact (name, email, massage) VALUES ('Sophia Lee', 'sophia.lee@example.com', 'Complaint about cleanliness.');

-- Пример 8
INSERT INTO contact (name, email, massage) VALUES ('Daniel Martinez', 'daniel.martinez@example.com', 'Request for a follow-up appointment.');

-- Пример 9
INSERT INTO contact (name, email, massage) VALUES ('Olivia Garcia', 'olivia.garcia@example.com', 'Concerns about medication side effects.');

-- Пример 10
INSERT INTO contact (name, email, massage) VALUES ('William Rodriguez', 'william.rodriguez@example.com', 'Appointment rescheduling request.');

-- Пример 11
INSERT INTO contact (name, email, massage) VALUES ('Ava Martinez', 'ava.martinez@example.com', 'Inquiry about insurance coverage.');

-- Пример 12
INSERT INTO contact (name, email, massage) VALUES ('Liam Hernandez', 'liam.hernandez@example.com', 'Follow-up on test results.');

-- Пример 13
INSERT INTO contact (name, email, massage) VALUES ('Emma Martinez', 'emma.martinez@example.com', 'Feedback on doctor\  bedside manner.');

INSERT INTO Category (name, description) VALUES
                                             ('Хирургия', 'Хирургия занимается оперативным лечением заболеваний и повреждений. Хирурги выполняют операции для удаления или исправления поврежденных тканей, органов или структур.'),
                                             ('Стоматология', 'Стоматология включает диагностику, лечение и профилактику заболеваний зубов, десен и ротовой полости. Стоматологи также проводят косметические процедуры.'),
                                             ('Урология', 'Урология специализируется на заболеваниях и расстройствах мочевыделительной системы и мужской репродуктивной системы. Урологи проводят хирургическое и медикаментозное лечение.'),
                                             ('Гинекология', 'Гинекология охватывает диагностику и лечение заболеваний женской репродуктивной системы. Гинекологи также проводят профилактические осмотры и консультируют по вопросам репродуктивного здоровья.'),
                                             ('Неврология', 'Неврология занимается исследованием, диагностикой и лечением заболеваний нервной системы, включая головной и спинной мозг, а также периферические нервы.');
-- Вставка дополнительных категорий
INSERT INTO Category (name, description) VALUES
                                             ('Кардиология', 'Кардиология занимается диагностикой и лечением заболеваний сердечно-сосудистой системы, включая болезни сердца, артерий и вен.'),
                                             ('Офтальмология', 'Офтальмология включает диагностику и лечение заболеваний глаз и зрительной системы. Офтальмологи проводят операции на глазах и коррекцию зрения.'),
                                             ('Дерматология', 'Дерматология специализируется на заболеваниях кожи, волос и ногтей. Дерматологи лечат различные кожные заболевания и проводят косметические процедуры.'),
                                             ('Педиатрия', 'Педиатрия занимается медицинским обслуживанием детей от рождения до подросткового возраста. Педиатры следят за развитием детей и лечат детские болезни.'),
                                             ('Эндокринология', 'Эндокринология охватывает диагностику и лечение заболеваний эндокринной системы, включая заболевания щитовидной железы, диабет и гормональные расстройства.'),
                                             ('Гастроэнтерология', 'Гастроэнтерология включает диагностику и лечение заболеваний пищеварительной системы, включая желудок, кишечник, печень и поджелудочную железу.'),
                                             ('Ревматология', 'Ревматология специализируется на диагностике и лечении ревматических заболеваний, таких как артрит, ревматизм и аутоиммунные заболевания.'),
                                             ('Психиатрия', 'Психиатрия занимается диагностикой и лечением психических расстройств и заболеваний, включая депрессию, шизофрению и тревожные расстройства.'),
                                             ('Аллергология и иммунология', 'Аллергология и иммунология охватывают диагностику и лечение аллергий и нарушений иммунной системы. Врачи проводят тесты на аллергию и назначают лечение.'),
                                             ('Онкология', 'Онкология занимается диагностикой и лечением раковых заболеваний. Онкологи проводят химиотерапию, радиотерапию и хирургические операции для удаления опухолей.'),
                                             ('Ортопедия', 'Ортопедия специализируется на диагностике и лечении заболеваний костей, суставов и мышц. Ортопеды проводят операции на костях и суставах, а также назначают физиотерапию.'),
                                             ('Пульмонология', 'Пульмонология включает диагностику и лечение заболеваний дыхательной системы, включая легкие и бронхи. Пульмонологи лечат астму, бронхит и другие респираторные заболевания.'),
                                             ('Нефрология', 'Нефрология охватывает диагностику и лечение заболеваний почек и мочевыводящей системы. Нефрологи проводят лечение почечной недостаточности и других заболеваний почек.'),
                                             ('Инфекционные болезни', 'Инфекционные болезни занимаются диагностикой и лечением инфекционных заболеваний, вызванных бактериями, вирусами, грибками и паразитами. Врачи назначают антивирусные, антибактериальные и другие лекарства.'),
                                             ('Травматология', 'Травматология включает диагностику и лечение травм, полученных в результате несчастных случаев, спортивных травм и других видов повреждений. Травматологи проводят операции и назначают реабилитацию.');
