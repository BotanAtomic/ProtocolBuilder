package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DungeonPartyFinderPlayer extends Object implements INetworkType {

    private int protocolId = 373;
    private Number playerId = 0;
    private String playerName = "";
    private int breed = 0;
    private boolean sex = false;
    private int level = 0;


    public int getTypeId() {
         return 373;
    }

    public DungeonPartyFinderPlayer initDungeonPartyFinderPlayer(Number param1,String  param2,int  param3,boolean  param4,int  param5) {
         this.playerId = param1;
         this.playerName = param2;
         this.breed = param3;
         this.sex = param4;
         this.level = param5;
         return this;
    }

    public void reset() {
         this.playerId = 0;
         this.playerName = "";
         this.breed = 0;
         this.sex = false;
         this.level = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_DungeonPartyFinderPlayer(param1);
    }

    public void serializeAs_DungeonPartyFinderPlayer(ICustomDataOutput param1) {
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeUTF(this.playerName);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DungeonPartyFinderPlayer(param1);
    }

    public void deserializeAs_DungeonPartyFinderPlayer(ICustomDataInput param1) {
         this._playerIdFunc(param1);
         this._playerNameFunc(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
         this._levelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DungeonPartyFinderPlayer(param1);
    }

    public void deserializeAsyncAs_DungeonPartyFinderPlayer(FuncTree param1) {
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._playerNameFunc);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
         param1.addChild(this._levelFunc);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of DungeonPartyFinderPlayer.playerId.");
         }
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
         {
            throw new Exception("Forbidden value (" + this.breed + ") on element of DungeonPartyFinderPlayer.breed.");
         }
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of DungeonPartyFinderPlayer.level.");
         }
    }

}