package package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FriendInformations extends AbstractContactInformations implements INetworkType {

    private int protocolId = 78;
    private int playerState = 99;
    private int lastConnection = 0;
    private int achievementPoints = 0;


    public int getTypeId() {
         return 78;
    }

    public FriendInformations initFriendInformations(int param1,String  param2,int  param3,int  param4,int  param5) {
         super.initAbstractContactInformations(param1,param2);
         this.playerState = param3;
         this.lastConnection = param4;
         this.achievementPoints = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.playerState = 99;
         this.lastConnection = 0;
         this.achievementPoints = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FriendInformations(param1);
    }

    public void serializeAs_FriendInformations(ICustomDataOutput param1) {
         super.serializeAs_AbstractContactInformations(param1);
         param1.writeByte(this.playerState);
         if(this.lastConnection < 0)
            throw new Exception("Forbidden value (" + this.lastConnection + ") on element lastConnection.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FriendInformations(param1);
    }

    public void deserializeAs_FriendInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._playerStateFunc(param1);
         this._lastConnectionFunc(param1);
         this._achievementPointsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendInformations(param1);
    }

    public void deserializeAsyncAs_FriendInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._playerStateFunc);
         param1.addChild(this._lastConnectionFunc);
         param1.addChild(this._achievementPointsFunc);
    }

    private void _playerStateFunc(ICustomDataInput param1) {
         this.playerState = param1.readByte();
         if(this.playerState < 0)
            throw new Exception("Forbidden value (" + this.playerState + ") on element of FriendInformations.playerState.");
    }

    private void _lastConnectionFunc(ICustomDataInput param1) {
         this.lastConnection = param1.readVarUhShort();
         if(this.lastConnection < 0)
            throw new Exception("Forbidden value (" + this.lastConnection + ") on element of FriendInformations.lastConnection.");
    }

    private void _achievementPointsFunc(ICustomDataInput param1) {
         this.achievementPoints = param1.readInt();
    }

}