<template>
  <div class="not-found">
    <div class="header">404</div>
    <div class="text">Sayfa bulunamadı.</div>
    <router-link to="/"><button class="button">Anasayfa</button></router-link>
  </div>
</template>

<style scoped>
.not-found {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 1.5rem 0;
    margin-top: 5rem;
    text-align: center;
}

.header {
    font-size: 10rem;
}

.text {
    font-size: 1.2rem;
    margin: 0.4rem;
}

.button {
    margin: 1rem 0 1rem 0;
    align-self: center;
    background-color: #4CAF50; /* Green */
    border: none;
    border-radius: 0.5rem;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
</style>
