Ext.define("CM.Sidebar.Button", {
    extend: "Ext.button.Button",

    initComponent: function() {
        Ext.apply(this, {
            text: this.class,
            cls: 'sidebar-class',
            border: false,
            height: 25,
            margin: '0 0 5',
            id: this.class + '-button',
            handler: this.loadClass
        });

        this.callParent(arguments);
    },

    loadClass: function(btn, evt) {
        var elId = btn.text.replace(' ', '-') + '-panel';

        if (!PageGlobals.contentPanel.getChildByElement(elId)) {
            PageGlobals.contentPanel.add(new CM.Class.Home({ class: btn.text, courseId: btn.courseId }));
        }

        PageGlobals.contentPanel.getLayout().setActiveItem(elId);
    }
});
