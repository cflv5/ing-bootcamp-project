<template>
  <div class="result" :class="{ danger: background}">
    <div class="message">
      <slot />
    </div>
    <button class="button" @click="onClick">Forma Dön</button>
  </div>
</template>

<script>
export default {
  props: ["background"],
  methods: {
    onClick() {
      this.$emit("reset");
    },
  },
};
</script>

<style scoped>
.result{
    display: flex;
    flex-direction: column;
    background: #ACE1AF;
    text-align: center;
    border-radius: 1rem;
    justify-self: center;
    align-items: center;
}

.danger {
    background: #e57373;
}

.message {
    font-size: 1.5rem;
    padding: 1rem;
}

.button {
    border: none;
    border-radius: 0.45rem;
    background: #0074D9;
    size: 2rem;
    width: 50%;
    padding: 1rem 2rem;
    margin: 1rem 0;
    color: white
}

@media (min-width: 820px) {
  .result {
    width: 75%;
    margin: auto;
  }
  .button {
    width: 25%;
  }
}
</style>
