# React + TypeScript + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend updating the configuration to enable type aware lint rules:

- Configure the top-level `parserOptions` property like this:

```js
export default {
  // other rules...
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
    project: ['./tsconfig.json', './tsconfig.node.json'],
    tsconfigRootDir: __dirname,
  },
}
```

- Replace `plugin:@typescript-eslint/recommended` to `plugin:@typescript-eslint/recommended-type-checked` or `plugin:@typescript-eslint/strict-type-checked`
- Optionally add `plugin:@typescript-eslint/stylistic-type-checked`
- Install [eslint-plugin-react](https://github.com/jsx-eslint/eslint-plugin-react) and add `plugin:react/recommended` & `plugin:react/jsx-runtime` to the `extends` list


## Tutorial de uso

  ```
  npm i 

  cd nombre-carpeta/
  ```

  ```
  npm run dev
  ```

## Proyecto React construido con arquitectura Hexagonal

```
src/
│   App.css
│   App.tsx
│   index.css
│   main.tsx
│   vite-env.d.ts
│   
├───assets/
│       react.svg
│       
├───components/
│   │   theme-provider.tsx
│   │   
│   ├───Home/
│   │       Home.tsx
│   │       Navbar.tsx
│   │       
│   ├───LoginForm/
│   │       LoginForm.tsx
│   │       
│   └───ui/
│           button.tsx
│           form.tsx
│           input.tsx
│           label.tsx
│           navigation-menu.tsx
│           toast.tsx
│           toaster.tsx
│           use-toast.ts
│
├───lib/
│       utils.ts
│       
├───pages/
│       Home.tsx
│       Login.tsx
│       
├───services/
│       api.ts
│       
├───types/
│       User.ts
│       
└───utils/
        validation.ts
```
