package package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PrismsListRegisterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6441;
    private boolean _isInitialized = false;
    private int listen = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6441;
    }

    public PrismsListRegisterMessage initPrismsListRegisterMessage(int param1) {
         this.listen = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.listen = 0;
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
         this.serializeAs_PrismsListRegisterMessage(param1);
    }

    public void serializeAs_PrismsListRegisterMessage(ICustomDataOutput param1) {
         param1.writeByte(this.listen);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismsListRegisterMessage(param1);
    }

    public void deserializeAs_PrismsListRegisterMessage(ICustomDataInput param1) {
         this._listenFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismsListRegisterMessage(param1);
    }

    public void deserializeAsyncAs_PrismsListRegisterMessage(FuncTree param1) {
         param1.addChild(this._listenFunc);
    }

    private void _listenFunc(ICustomDataInput param1) {
         this.listen = param1.readByte();
         if(this.listen < 0)
            throw new Exception("Forbidden value (" + this.listen + ") on element of PrismsListRegisterMessage.listen.");
    }

}