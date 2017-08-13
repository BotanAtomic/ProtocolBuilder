package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AchievementFinishedInformationMessage extends AchievementFinishedMessage implements INetworkMessage {

    private int protocolId = 6381;
    private boolean _isInitialized = false;
    private String name = "";
    private Number playerId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6381;
    }

    public AchievementFinishedInformationMessage initAchievementFinishedInformationMessage(int param1,int  param2,String  param3,Number  param4) {
         super.initAchievementFinishedMessage(param1,param2);
         this.name = param3;
         this.playerId = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
         this.playerId = 0;
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
         this.serializeAs_AchievementFinishedInformationMessage(param1);
    }

    public void serializeAs_AchievementFinishedInformationMessage(ICustomDataOutput param1) {
         super.serializeAs_AchievementFinishedMessage(param1);
         param1.writeUTF(this.name);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementFinishedInformationMessage(param1);
    }

    public void deserializeAs_AchievementFinishedInformationMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameFunc(param1);
         this._playerIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementFinishedInformationMessage(param1);
    }

    public void deserializeAsyncAs_AchievementFinishedInformationMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
         param1.addChild(this._playerIdFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of AchievementFinishedInformationMessage.playerId.");
         }
    }

}