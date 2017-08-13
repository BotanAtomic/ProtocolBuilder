package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class IgnoredOnlineInformations extends IgnoredInformations implements INetworkType {

    private int protocolId = 105;
    private Number playerId = 0;
    private String playerName = "";
    private int breed = 0;
    private boolean sex = false;


    public int getTypeId() {
         return 105;
    }

    public IgnoredOnlineInformations initIgnoredOnlineInformations(int param1,String  param2,Number  param3,String  param4,int  param5,boolean  param6) {
         super.initIgnoredInformations(param1,param2);
         this.playerId = param3;
         this.playerName = param4;
         this.breed = param5;
         this.sex = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.playerId = 0;
         this.playerName = "";
         this.breed = 0;
         this.sex = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_IgnoredOnlineInformations(param1);
    }

    public void serializeAs_IgnoredOnlineInformations(ICustomDataOutput param1) {
         super.serializeAs_IgnoredInformations(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeUTF(this.playerName);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IgnoredOnlineInformations(param1);
    }

    public void deserializeAs_IgnoredOnlineInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._playerIdFunc(param1);
         this._playerNameFunc(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IgnoredOnlineInformations(param1);
    }

    public void deserializeAsyncAs_IgnoredOnlineInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._playerNameFunc);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of IgnoredOnlineInformations.playerId.");
         }
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
         {
            throw new Exception("Forbidden value (" + this.breed + ") on element of IgnoredOnlineInformations.breed.");
         }
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

}