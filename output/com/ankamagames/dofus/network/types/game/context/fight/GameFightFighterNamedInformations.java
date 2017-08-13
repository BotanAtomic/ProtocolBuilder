package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightFighterNamedInformations extends GameFightFighterInformations implements INetworkType {

    private int protocolId = 158;
    private String name = "";
    private PlayerStatus status;
    private FuncTree _statustree;


    public int getTypeId() {
         return 158;
    }

    public GameFightFighterNamedInformations initGameFightFighterNamedInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector<uint>  param8,String  param9,PlayerStatus  param10) {
         super.initGameFightFighterInformations(param1,param2,param3,param4,param5,param6,param7,param8);
         this.name = param9;
         this.status = param10;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
         this.status = new PlayerStatus();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightFighterNamedInformations(param1);
    }

    public void serializeAs_GameFightFighterNamedInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterInformations(param1);
         param1.writeUTF(this.name);
         this.status.serializeAs_PlayerStatus(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterNamedInformations(param1);
    }

    public void deserializeAs_GameFightFighterNamedInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameFunc(param1);
         this.status = new PlayerStatus();
         this.status.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightFighterNamedInformations(param1);
    }

    public void deserializeAsyncAs_GameFightFighterNamedInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
         this._statustree = param1.addChild(this._statustreeFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _statustreeFunc(ICustomDataInput param1) {
         this.status = new PlayerStatus();
         this.status.deserializeAsync(this._statustree);
    }

}