const amqp = require("amqplib");

setTimeout(() => {
    rabbitMqConnection();
}, 30000);
console.log("Connected to RabbitMQ");

async function rabbitMqConnection() {
    try {
        const connection = await amqp.connect({
            hostname: "rabbitmq",
            port: 5672,
            username: "bootcamp",
            password: "bootcamp"
        });
        const channel = await connection.createChannel();
        await channel.assertQueue("report-queue");
        await channel.assertExchange("report-exchange", "direct");
        channel.bindQueue("report-queue", "report-exchange", "report-routing");

        channel.consume("report-queue", response => {
            const report = JSON.parse(response.content.toString());
            console.log("http://localhost:5000/report/" + report.id);
        });

    } catch (error) {
        console.log(error);
    }
}