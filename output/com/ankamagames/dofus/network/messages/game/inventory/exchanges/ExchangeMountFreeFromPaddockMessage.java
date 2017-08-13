package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeMountFreeFromPaddockMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6055;
    private boolean _isInitialized = false;
    private String name = "";
    private int worldX = 0;
    private int worldY = 0;
    private String liberator = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6055;
    }

    public ExchangeMountFreeFromPaddockMessage initExchangeMountFreeFromPaddockMessage(String param1,int  param2,int  param3,String  param4) {
         this.name = param1;
         this.worldX = param2;
         this.worldY = param3;
         this.liberator = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.name = "";
         this.worldX = 0;
         this.worldY = 0;
         this.liberator = "";
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
         this.serializeAs_ExchangeMountFreeFromPaddockMessage(param1);
    }

    public void serializeAs_ExchangeMountFreeFromPaddockMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         param1.writeUTF(this.liberator);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeMountFreeFromPaddockMessage(param1);
    }

    public void deserializeAs_ExchangeMountFreeFromPaddockMessage(ICustomDataInput param1) {
         this._nameFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._liberatorFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeMountFreeFromPaddockMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeMountFreeFromPaddockMessage(FuncTree param1) {
         param1.addChild(this._nameFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._liberatorFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of ExchangeMountFreeFromPaddockMessage.worldX.");
         }
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of ExchangeMountFreeFromPaddockMessage.worldY.");
         }
    }

    private void _liberatorFunc(ICustomDataInput param1) {
         this.liberator = param1.readUTF();
    }

}