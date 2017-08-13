package package com.ankamagames.dofus.network.messages.authorized;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ConsoleCommandsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6127;
    private boolean _isInitialized = false;
    private Vector.<String> aliases = ;
    private Vector.<String> args = ;
    private Vector.<String> descriptions = ;
    private FuncTree _aliasestree = ;
    private FuncTree _argstree = ;
    private FuncTree _descriptionstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private String _loc9_ = null;
    private String _loc10_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc6_ = param1.readUnsignedShort();
    private int _loc7_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6127;
    }

    public ConsoleCommandsListMessage initConsoleCommandsListMessage(Vector.<String> param1,Vector.<String>  param2,Vector.<String>  param3) {
         this.aliases = param1;
         this.args = param2;
         this.descriptions = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.aliases = new Vector.<String>();
         this.args = new Vector.<String>();
         this.descriptions = new Vector.<String>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ConsoleCommandsListMessage(param1);
    }

    public void serializeAs_ConsoleCommandsListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.aliases.length);
         int _loc2_ = 0;
         while(_loc2_ < this.aliases.length)
            param1.writeUTF(this.aliases[_loc2_]);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ConsoleCommandsListMessage(param1);
    }

    public void deserializeAs_ConsoleCommandsListMessage(ICustomDataInput param1) {
         String _loc8_ = null;
         String _loc9_ = null;
         String _loc10_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc8_ = param1.readUTF();
            this.aliases.push(_loc8_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ConsoleCommandsListMessage(param1);
    }

    public void deserializeAsyncAs_ConsoleCommandsListMessage(FuncTree param1) {
         this._aliasestree = param1.addChild(this._aliasestreeFunc);
         this._argstree = param1.addChild(this._argstreeFunc);
         this._descriptionstree = param1.addChild(this._descriptionstreeFunc);
    }

    private void _aliasestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._aliasestree.addChild(this._aliasesFunc);
            _loc3_++;
    }

    private void _aliasesFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.aliases.push(_loc2_);
    }

    private void _argstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._argstree.addChild(this._argsFunc);
            _loc3_++;
    }

    private void _argsFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.args.push(_loc2_);
    }

    private void _descriptionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._descriptionstree.addChild(this._descriptionsFunc);
            _loc3_++;
    }

    private void _descriptionsFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.descriptions.push(_loc2_);
    }

}