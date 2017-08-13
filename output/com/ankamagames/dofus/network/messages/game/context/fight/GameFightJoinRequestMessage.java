package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightJoinRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 701;
    private boolean _isInitialized = false;
    private Number fighterId = 0;
    private int fightId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 701;
    }

    public GameFightJoinRequestMessage initGameFightJoinRequestMessage(Number param1,int  param2) {
         this.fighterId = param1;
         this.fightId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fighterId = 0;
         this.fightId = 0;
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
         this.serializeAs_GameFightJoinRequestMessage(param1);
    }

    public void serializeAs_GameFightJoinRequestMessage(ICustomDataOutput param1) {
         if(this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterId + ") on element fighterId.");
         }
         param1.writeDouble(this.fighterId);
         param1.writeInt(this.fightId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightJoinRequestMessage(param1);
    }

    public void deserializeAs_GameFightJoinRequestMessage(ICustomDataInput param1) {
         this._fighterIdFunc(param1);
         this._fightIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightJoinRequestMessage(param1);
    }

    public void deserializeAsyncAs_GameFightJoinRequestMessage(FuncTree param1) {
         param1.addChild(this._fighterIdFunc);
         param1.addChild(this._fightIdFunc);
    }

    private void _fighterIdFunc(ICustomDataInput param1) {
         this.fighterId = param1.readDouble();
         if(this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterId + ") on element of GameFightJoinRequestMessage.fighterId.");
         }
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

}