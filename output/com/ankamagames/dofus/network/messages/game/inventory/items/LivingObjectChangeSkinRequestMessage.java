package com.ankamagames.dofus.network.messages.game.inventory.items;

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
import java.lang.Exception;
import java.lang.Exception;

public class LivingObjectChangeSkinRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5725;
    private boolean _isInitialized = false;
    private int livingUID = 0;
    private int livingPosition = 0;
    private int skinId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5725;
    }

    public LivingObjectChangeSkinRequestMessage initLivingObjectChangeSkinRequestMessage(int param1,int  param2,int  param3) {
         this.livingUID = param1;
         this.livingPosition = param2;
         this.skinId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.livingUID = 0;
         this.livingPosition = 0;
         this.skinId = 0;
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
         this.serializeAs_LivingObjectChangeSkinRequestMessage(param1);
    }

    public void serializeAs_LivingObjectChangeSkinRequestMessage(ICustomDataOutput param1) {
         if(this.livingUID < 0)
         {
            throw new Exception("Forbidden value (" + this.livingUID + ") on element livingUID.");
         }
         param1.writeVarInt(this.livingUID);
         if(this.livingPosition < 0 || this.livingPosition > 255)
         {
            throw new Exception("Forbidden value (" + this.livingPosition + ") on element livingPosition.");
         }
         param1.writeByte(this.livingPosition);
         if(this.skinId < 0)
         {
            throw new Exception("Forbidden value (" + this.skinId + ") on element skinId.");
         }
         param1.writeVarInt(this.skinId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LivingObjectChangeSkinRequestMessage(param1);
    }

    public void deserializeAs_LivingObjectChangeSkinRequestMessage(ICustomDataInput param1) {
         this._livingUIDFunc(param1);
         this._livingPositionFunc(param1);
         this._skinIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LivingObjectChangeSkinRequestMessage(param1);
    }

    public void deserializeAsyncAs_LivingObjectChangeSkinRequestMessage(FuncTree param1) {
         param1.addChild(this._livingUIDFunc);
         param1.addChild(this._livingPositionFunc);
         param1.addChild(this._skinIdFunc);
    }

    private void _livingUIDFunc(ICustomDataInput param1) {
         this.livingUID = param1.readVarUhInt();
         if(this.livingUID < 0)
         {
            throw new Exception("Forbidden value (" + this.livingUID + ") on element of LivingObjectChangeSkinRequestMessage.livingUID.");
         }
    }

    private void _livingPositionFunc(ICustomDataInput param1) {
         this.livingPosition = param1.readUnsignedByte();
         if(this.livingPosition < 0 || this.livingPosition > 255)
         {
            throw new Exception("Forbidden value (" + this.livingPosition + ") on element of LivingObjectChangeSkinRequestMessage.livingPosition.");
         }
    }

    private void _skinIdFunc(ICustomDataInput param1) {
         this.skinId = param1.readVarUhInt();
         if(this.skinId < 0)
         {
            throw new Exception("Forbidden value (" + this.skinId + ") on element of LivingObjectChangeSkinRequestMessage.skinId.");
         }
    }

}