FROM node:14-slim
WORKDIR /contact-service
RUN npm install -g serve
COPY dist/ .
CMD [ "serve", "-s", ".", "-l", "5000"]