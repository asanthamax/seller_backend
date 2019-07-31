CREATE TABLE `authority` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
);


CREATE TABLE `oauth_access_token` (
  `token_id` varchar(100) NOT NULL,
  `token` text NOT NULL,
  `authentication_id` varchar(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `client_id` varchar(100) NOT NULL,
  `authentication` text NOT NULL,
  `refresh_token` varchar(100) NOT NULL
);

CREATE TABLE `oauth_approvals` (
  `userId` varchar(100) NOT NULL,
  `clientId` varchar(100) NOT NULL,
  `scope` varchar(100) NOT NULL,
  `expiresAt` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `lastModifiedAt` varchar(100) NOT NULL
);

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(100) NOT NULL,
  `resource_ids` varchar(100) NOT NULL,
  `scope` varchar(100) NOT NULL,
  `authorized_grant_types` varchar(100) NOT NULL,
  `web_server_redirect_uri` varchar(100) NOT NULL,
  `authorities` varchar(100) NOT NULL,
  `access_token_validity` int(100) NOT NULL,
  `refresh_token_validity` int(100) NOT NULL,
  `additional_information` varchar(100) NOT NULL,
  `autoapprove` varchar(100) NOT NULL,
  `client_secret` varchar(100) NOT NULL
);

CREATE TABLE `oauth_client_token` (
  `token_id` varchar(100) NOT NULL,
  `token` varchar(100) NOT NULL,
  `authentication_id` varchar(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `client_id` varchar(100) NOT NULL
);

CREATE TABLE `oauth_code` (
  `code` varchar(100) NOT NULL,
  `authentication` varchar(100) NOT NULL
);

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(100) NOT NULL,
  `token` text NOT NULL,
  `authentication` text NOT NULL
);

CREATE TABLE `oauth_user` (
  `user_name` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `account_expired` tinyint(1) NOT NULL,
  `account_locked` tinyint(1) NOT NULL,
  `credentials_expired` tinyint(1) NOT NULL,
  `id` int(11) NOT NULL,
  `enabled` tinyint(1) NOT NULL
);

CREATE TABLE `user_authorities` (
  `user_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL
);

ALTER TABLE `authority`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth_access_token`
--
ALTER TABLE `oauth_access_token`
  ADD PRIMARY KEY (`token_id`);

--
-- Indexes for table `oauth_approvals`
--
ALTER TABLE `oauth_approvals`
  ADD PRIMARY KEY (`userId`,`clientId`);

--
-- Indexes for table `oauth_client_details`
--
ALTER TABLE `oauth_client_details`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `oauth_client_token`
--
ALTER TABLE `oauth_client_token`
  ADD PRIMARY KEY (`token_id`);

--
-- Indexes for table `oauth_refresh_token`
--
ALTER TABLE `oauth_refresh_token`
  ADD PRIMARY KEY (`token_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `oauth_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_authorities`
--
ALTER TABLE `user_authorities`
  ADD PRIMARY KEY (`user_id`,`authority_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `oauth_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

CREATE PROCEDURE `SellerPayments`()
BEGIN
SELECT SUM(amount) as amount,COUNT(*) as numOrders,userid
FROM sellerpayments
WHERE recieved_date >= DATE(ADDDATE(recieved_date, INTERVAL 30 DAY))
GROUP BY userid;
END



