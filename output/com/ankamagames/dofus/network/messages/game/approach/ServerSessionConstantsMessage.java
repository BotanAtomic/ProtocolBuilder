package package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.approach.ServerSessionConstant;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class ServerSessionConstantsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6434;
    private boolean _isInitialized = false;
    private Vector.<ServerSessionConstant> variables = ;
    private FuncTree _variablestree = ;
    private int _loc2_ = 0;
    private ServerSessionConstant _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private ServerSessionConstant _loc3_ = ProtocolTypeManager.getInstance(ServerSessionConstant,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6434;
    }

    public ServerSessionConstantsMessage initServerSessionConstantsMessage(Vector.<ServerSessionConstant> param1) {
         this.variables = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.variables = new Vector.<ServerSessionConstant>();
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
         this.serializeAs_ServerSessionConstantsMessage(param1);
    }

    public void serializeAs_ServerSessionConstantsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.variables.length);
         int _loc2_ = 0;
         while(_loc2_ < this.variables.length)
            param1.writeShort((this.variables[_loc2_] as ServerSessionConstant).getTypeId());
            (this.variables[_loc2_] as ServerSessionConstant).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerSessionConstantsMessage(param1);
    }

    public void deserializeAs_ServerSessionConstantsMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         ServerSessionConstant _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(ServerSessionConstant,_loc4_);
            _loc5_.deserialize(param1);
            this.variables.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerSessionConstantsMessage(param1);
    }

    public void deserializeAsyncAs_ServerSessionConstantsMessage(FuncTree param1) {
         this._variablestree = param1.addChild(this._variablestreeFunc);
    }

    private void _variablestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._variablestree.addChild(this._variablesFunc);
            _loc3_++;
    }

    private void _variablesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         ServerSessionConstant _loc3_ = ProtocolTypeManager.getInstance(ServerSessionConstant,_loc2_);
         _loc3_.deserialize(param1);
         this.variables.push(_loc3_);
    }

}