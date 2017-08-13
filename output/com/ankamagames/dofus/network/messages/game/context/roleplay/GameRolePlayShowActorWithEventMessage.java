package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayShowActorWithEventMessage extends GameRolePlayShowActorMessage implements INetworkMessage {

    private int protocolId = 6407;
    private boolean _isInitialized = false;
    private int actorEventId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6407;
    }

    public GameRolePlayShowActorWithEventMessage initGameRolePlayShowActorWithEventMessage(GameRolePlayActorInformations param1,int  param2) {
         super.initGameRolePlayShowActorMessage(param1);
         this.actorEventId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.actorEventId = 0;
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
         this.serializeAs_GameRolePlayShowActorWithEventMessage(param1);
    }

    public void serializeAs_GameRolePlayShowActorWithEventMessage(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayShowActorMessage(param1);
         if(this.actorEventId < 0)
         {
            throw new Exception("Forbidden value (" + this.actorEventId + ") on element actorEventId.");
         }
         param1.writeByte(this.actorEventId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayShowActorWithEventMessage(param1);
    }

    public void deserializeAs_GameRolePlayShowActorWithEventMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._actorEventIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayShowActorWithEventMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayShowActorWithEventMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._actorEventIdFunc);
    }

    private void _actorEventIdFunc(ICustomDataInput param1) {
         this.actorEventId = param1.readByte();
         if(this.actorEventId < 0)
         {
            throw new Exception("Forbidden value (" + this.actorEventId + ") on element of GameRolePlayShowActorWithEventMessage.actorEventId.");
         }
    }

}