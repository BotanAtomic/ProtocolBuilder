package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightFighterNamedLightInformations extends GameFightFighterLightInformations implements INetworkType {

    private int protocolId = 456;
    private String name = "";


    public int getTypeId() {
         return 456;
    }

    public GameFightFighterNamedLightInformations initGameFightFighterNamedLightInformations(Number param1,int  param2,int  param3,int  param4,boolean  param5,boolean  param6,String  param7) {
         super.initGameFightFighterLightInformations(param1,param2,param3,param4,param5,param6);
         this.name = param7;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightFighterNamedLightInformations(param1);
    }

    public void serializeAs_GameFightFighterNamedLightInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterLightInformations(param1);
         param1.writeUTF(this.name);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterNamedLightInformations(param1);
    }

    public void deserializeAs_GameFightFighterNamedLightInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightFighterNamedLightInformations(param1);
    }

    public void deserializeAsyncAs_GameFightFighterNamedLightInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

}