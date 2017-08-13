package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameContextRefreshEntityLookMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5637;
    private boolean _isInitialized = false;
    private Number id = 0;
    private EntityLook look;
    private FuncTree _looktree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5637;
    }

    public GameContextRefreshEntityLookMessage initGameContextRefreshEntityLookMessage(Number param1,EntityLook  param2) {
         this.id = param1;
         this.look = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.look = new EntityLook();
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
         this.serializeAs_GameContextRefreshEntityLookMessage(param1);
    }

    public void serializeAs_GameContextRefreshEntityLookMessage(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         this.look.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextRefreshEntityLookMessage(param1);
    }

    public void deserializeAs_GameContextRefreshEntityLookMessage(ICustomDataInput param1) {
         this._idFunc(param1);
         this.look = new EntityLook();
         this.look.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextRefreshEntityLookMessage(param1);
    }

    public void deserializeAsyncAs_GameContextRefreshEntityLookMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
         this._looktree = param1.addChild(this._looktreeFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of GameContextRefreshEntityLookMessage.id.");
         }
    }

    private void _looktreeFunc(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserializeAsync(this._looktree);
    }

}